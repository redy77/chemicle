package com.chemcool.school.answers.service;

import com.chemcool.school.answers.domain.jwt.JwtUserAuthorization;
import com.chemcool.school.answers.domain.jwt.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtAuthorizationService {
    private final JwtUserAuthorization userAuthorization;

    public User getUser(String token) {
        return userAuthorization.getUser(token);
    }
}
