package com.chemcool.school.tasks.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

@Component
public interface JWTParserInterface {
    Claims getClaimsFromToken(String token);
}
