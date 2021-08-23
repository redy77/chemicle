package com.chemcool.school.tasks.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Data
public class JWTParser implements JWTParserInterface{

    @Value("${authentication.jwt.secretKey}")
    private String jwtSecret;

    @Override
    public Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token.split("Bearer ")[1])
                    .getBody();
        } catch (Exception e) {
            System.err.println("Ошибка при получении Claims  из токена!");
            claims = null;
        }
        return claims;
    }

    public void checkRolesOnAdmin(String token) {
        ArrayList roles = getClaimsFromToken(token).get("roles", ArrayList.class);
        if (!roles.contains("ROLE_ADMIN")) {
            throw new RuntimeException("Создавать могут только админы.");
        }
    }

}

