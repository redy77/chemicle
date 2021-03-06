package com.chemcool.school.registration.service;

import com.chemcool.school.registration.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserProxyService {

    private final RegisterUserEventNotificationService registerUserEventNotificationService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String add(RegisterUserExample registerUserExample) {

        RegisterUser registerUser = RegisterUserFactory.createUser(registerUserExample);
        registerUser.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        registerUserEventNotificationService.send(
                RegisterUserEventFactory.createEvent(registerUser, RegisterUserEventType.CREATE)
        );
        return registerUser.getId();
    }
}