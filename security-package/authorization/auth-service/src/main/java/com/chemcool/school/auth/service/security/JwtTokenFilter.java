package com.chemcool.school.auth.service.security;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtBuilder JwtBuilder;

    @Override
    public void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            String token = JwtBuilder.resolveToken(servletRequest);
            if (token != null && JwtBuilder.validateToken(token)) {
                Authentication authentication = JwtBuilder.getAuthentication(token);
                if (authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (ExpiredJwtException ex) {
            String isRefreshToken = servletRequest.getHeader("isRefreshToken");
            String requestURL = servletRequest.getRequestURL().toString();
            if (isRefreshToken != null && isRefreshToken.equals("true") && requestURL.contains("refreshtoken")) {
                allowForRefreshToken(ex, servletRequest);
            } else {
                servletRequest.setAttribute("exception", ex);
            }
        } catch (BadCredentialsException ex) {
            servletRequest.setAttribute("exception", ex);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void allowForRefreshToken(ExpiredJwtException ex, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(null, null, null);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        request.setAttribute("claims", ex.getClaims());
    }
}
