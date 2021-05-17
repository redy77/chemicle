package com.chemcool.school.games.twoofoureight.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
public class JWTParser {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public Jws<Claims> getUserOfToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
    }

    public String getIdUserOfToken(String token) {
        Jws<Claims> jws = getUserOfToken(token);
        return jws.getBody().getSubject();
    }
}

