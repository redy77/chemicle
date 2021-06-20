package com.chemcool.school.games.twoofoureight.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

@Component
public interface JWTParserInterface {
    Claims getClaimsFromToken(String token);
}
