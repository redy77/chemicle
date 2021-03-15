package com.chemcool.school.auth.web.api.service;

import com.chemcool.school.auth.service.security.JwtBuilder;
import com.chemcool.school.auth.service.security.UserDetailsServiceImpl;
import com.chemcool.school.auth.service.storage.UserWithRegistrationRepository;
import com.chemcool.school.auth.web.api.dto.UserSendFromClient;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CheckUserRegistration {
    private final AuthenticationManager authenticate;
    private final JwtBuilder jwtBuilder;

    public Map<Object, Object> responseSendToken(UserSendFromClient userClient) {
        authenticate.authenticate(new UsernamePasswordAuthenticationToken(userClient.getEmail(), userClient.getPassword()));
        String userEmail = userClient.getEmail();
        String token = jwtBuilder.createTokens(userEmail);
        return createMapResponse(userEmail, token);
    }

    public Map<Object, Object> createMapResponse(String userEmail, String token) {
        Map<Object, Object> response = new HashMap<>();
        response.put("email", userEmail);
        response.put("token", token);
        return response;
    }
}
