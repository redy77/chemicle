package com.chemcool.school.auth.service.security;

import com.chemcool.school.auth.service.config.AppProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@AllArgsConstructor
@Service
public class JwtUtil {

    private final AppProperties prop;


    public String generateJwt(Authentication auth) {
        UserDetailsImpl details = (UserDetailsImpl) auth.getPrincipal();

        return Jwts.builder()
                .setIssuer(prop.auth.tokenIssuer)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + prop.auth.tokenExpiration))
                .claim("id", details.getId())
                .claim("email", details.getEmail())
                .claim("name", details.getName())
                .signWith(SignatureAlgorithm.HS512, prop.auth.tokenSecret)
                .compact();
    }

    public Claims decodeJwt(String jwt) {
        return Jwts.parser()
                .setSigningKey(prop.auth.tokenSecret)
                .parseClaimsJws(jwt)
                .getBody();
    }

}