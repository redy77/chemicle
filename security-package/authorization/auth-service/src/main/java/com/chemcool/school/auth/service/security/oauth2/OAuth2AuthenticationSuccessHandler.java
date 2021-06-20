package com.chemcool.school.auth.service.security.oauth2;

import com.chemcool.school.auth.service.config.AppProperties;
import com.chemcool.school.auth.service.exeption.BadRequestException;
import com.chemcool.school.auth.service.security.JwtUtil;
import com.chemcool.school.auth.service.util.CookieUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import static com.chemcool.school.auth.service.security.oauth2.HttpCookieOAuth2AuthorizationRequestRepository.REDIRECT_URI_PARAM_COOKIE_NAME;

@Slf4j
@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;
    private final AppProperties prop;
    private final HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    OAuth2AuthenticationSuccessHandler(JwtUtil jwtUtil,
                                       AppProperties prop,
                                       HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository) {
        this.jwtUtil = jwtUtil;
        this.prop = prop;
        this.httpCookieOAuth2AuthorizationRequestRepository = httpCookieOAuth2AuthorizationRequestRepository;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        String targetUrl = determineTargetUrl(request, response, authentication);

        if (response.isCommitted()) {
            logger.debug("Ответ уже отправлен. Невозможно перенаправить на " + targetUrl);
            return;
        }

        clearAuthenticationAttributes(request, response);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) {

        Optional<String> redirectUri = CookieUtils.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME)
                .map(Cookie::getValue);
        if (redirectUri.isPresent() && !isAuthorizedRedirectUri(redirectUri.get())) {
            throw new BadRequestException("Вы не авторизованы , поэтому не можем вас перенаправить");
        }

        String targetUrl = redirectUri.orElse(getDefaultTargetUrl());

        String token = jwtUtil.generateJwt(authentication);

        return UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam("token", token)
                .build().toUriString();
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {
        super.clearAuthenticationAttributes(request);
        httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(request, response);
    }

    private boolean isAuthorizedRedirectUri(String uri) {
        URI clientRedirectUri = URI.create(uri);

        return prop.oauth2.authorizedRedirectUris
                .stream()
                .anyMatch(
                        authorizedRedirectUri -> {
                            // Проверяем только хост и порт.
                            URI authorizedURI = URI.create(authorizedRedirectUri);

                            return authorizedURI.getHost().equalsIgnoreCase(clientRedirectUri.getHost())
                                    && authorizedURI.getPort() == clientRedirectUri.getPort();
                        }
                );
    }

}
