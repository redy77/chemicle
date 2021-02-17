package com.chemcool.school.auth.web.api.controllers;

import com.chemcool.school.auth.service.security.JwtBuilder;
import com.chemcool.school.auth.web.api.dto.UserSendFromClient;
import com.chemcool.school.auth.web.api.service.CheckUserRegistration;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LoginControllers {
    private final CheckUserRegistration checkUserRegistration;
    private final JwtBuilder jwtBuilder;

    @PostMapping("/login")
    public ResponseEntity<?> createNewTask(@RequestBody UserSendFromClient userSendFromClient) {
        try {
            return ResponseEntity.ok(checkUserRegistration.responseSendToken(userSendFromClient));
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid email/password", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/refreshtoken")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) throws Exception {
        DefaultClaims claims = (io.jsonwebtoken.impl.DefaultClaims) request.getAttribute("claims");
        Map<String, Object> expectedMap = getMapFromIoJsonwebtokenClaims(claims);
        String token = jwtBuilder.createRefreshToken(expectedMap, expectedMap.get("sub").toString());
        Map<Object, Object> response = checkUserRegistration.createMapResponse(expectedMap.get("sub").toString(), token);
        return ResponseEntity.ok(response);
    }

    public Map<String, Object> getMapFromIoJsonwebtokenClaims(DefaultClaims claims) {
        Map<String, Object> expectedMap = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : claims.entrySet()) {
            expectedMap.put(entry.getKey(), entry.getValue());
        }
        return expectedMap;
    }
}
