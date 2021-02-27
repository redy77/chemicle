package com.chemcool.school.registration.service;

import com.chemcool.school.registration.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserProxyService {

    private final RegisterUserEventNotificationService registerUserEventNotificationService;
    private final PasswordEncoder passwordEncoder;

    public String add(RegisterUserExample registerUserExample) {

        registerUserExample.setUserExamplePassword(passwordEncoder.encode(registerUserExample.getUserExamplePassword()));
        RegisterUser registerUser = RegisterUserFactory.createUser(registerUserExample);

        registerUserEventNotificationService.send(
                RegisterUserEventFactory.createEvent(registerUser, RegisterUserEventType.CREATE)
        );
        return registerUser.getId();
    }
}