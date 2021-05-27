package com.chemcool.school.answers.domain.jwt;

public interface JwtUserAuthorization {
    User getUser(String token);
}
