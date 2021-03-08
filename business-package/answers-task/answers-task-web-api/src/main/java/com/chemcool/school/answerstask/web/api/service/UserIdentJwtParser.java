package com.chemcool.school.answerstask.web.api.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserIdentJwtParser {

    @Value("${authentication.jwt.secretKey}")
    private String SECRET_KEY;

    public Jws<Claims> getUserOfToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
    }

    public String getEmailUserOfToken(String token) {
        Jws<Claims> jws = getUserOfToken(token);
        return jws.getBody().getSubject();
    }

    public String getIdUserOfToken(String token) {
        Jws<Claims> jws = getUserOfToken(token);
        return jws.getBody().get("userId", String.class);
    }
}
