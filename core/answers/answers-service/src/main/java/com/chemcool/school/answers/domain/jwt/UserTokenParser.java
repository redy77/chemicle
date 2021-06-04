package com.chemcool.school.answers.domain.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserTokenParser implements JwtUserAuthorization {
    @Value("${authentication.jwt.secretKey}")
    private String secret;

    @Override
    public User getUser(String token) {

        if (token == null || token.isBlank()) {
            log.error("Токен пользователя равен: '{}'", token);
            throw new AuthorizationException("Токен пользователя отсутствует.");
        }

        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

        return UserFactory.create(claims);
    }
}
