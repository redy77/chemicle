package com.chemcool.school.games.twoofoureight.jwt;

import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

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
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            System.err.println("Ошибка при получении Claims  из токена!");
            claims = null;
        }
        return claims;
    }

    public String getUserIdFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

}

