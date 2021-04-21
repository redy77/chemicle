package com.chemcool.school.chat.web.api.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
@Data
public class TokenParser {

    private static final String SECRET_KEY = "secret";

    private Jws<Claims> getJws(String token) {
        String key = Base64.getEncoder().encodeToString(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token);
    }

    public String getUserIdFromToken(String token) {
        return getJws(token).getBody().getSubject();
    }

    public String getUserNameFromToken(String token) {
        return getJws(token).getBody().get("name", String.class);
    }

    public String getUserRoleFromToken(String token) {
        return getJws(token).getBody().get("role", String.class);
    }
}
