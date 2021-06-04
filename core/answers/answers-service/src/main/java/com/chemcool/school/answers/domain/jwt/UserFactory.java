package com.chemcool.school.answers.domain.jwt;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserFactory {
    public static User create(Claims claims) {

        if (claims != null) {
            String userId = claims.get("id", String.class);
            String name = claims.get("name", String.class);
            String email = claims.get("email", String.class);

            return new User(
                    userId,
                    name,
                    email
            );
        } else {
            log.error("Пользователь из токена не получен.");
            throw new AuthorizationException("Ошибка при получении Claims  из токена!");

        }
    }
}
