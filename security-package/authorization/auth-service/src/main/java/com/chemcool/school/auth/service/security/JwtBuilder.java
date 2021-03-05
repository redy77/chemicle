package com.chemcool.school.auth.service.security;

import com.chemcool.school.auth.service.domain.RegisterUser;
import com.chemcool.school.auth.service.storage.UserWithRegistrationRepository;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtBuilder {

    private final UserDetailsServiceImpl userDetailsService;
    private final UserWithRegistrationRepository userWithRegistrationRepository;

    @Value("${user.jwt.validityTokenInMilliSeconds}")
    private String TOKEN_VALIDITY_PERIOD_IN_MILLI_SECONDS;

    @Value("${user.jwt.secretKey}")
    private String SECRET_KEY;

    @Value("${user.jwt.header}")
    private String HEADER_FROM_AUTHENTICATION;

    @Value("${user.jwt.validityRefreshTokenInMilliSeconds}")
    private String REFRESH_TOKEN_VALIDITY_PERIOD_IN_MILLI_SECONDS;

    public String createTokens(String email) {
        Date now = new Date();
        Date date = new Date(now.getTime() + Integer.parseInt(TOKEN_VALIDITY_PERIOD_IN_MILLI_SECONDS));
        RegisterUser user = userWithRegistrationRepository.findByEmail(email);
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("nick", user.getNick());
        claims.put("role", user.getRole());
        return Jwts.builder().setClaims(claims)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return !claimsJws.getBody().getExpiration().before(new Date());
        } catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", ex);
        } catch (ExpiredJwtException ex) {
            throw ex;
        }
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUserName(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUserName(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
        return request.getHeader(HEADER_FROM_AUTHENTICATION);
    }

    public String createRefreshToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Integer.parseInt(REFRESH_TOKEN_VALIDITY_PERIOD_IN_MILLI_SECONDS)))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
    }

}