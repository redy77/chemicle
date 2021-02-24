package com.chemcool.school.registration.service;

import com.chemcool.school.registration.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserProxyService {

    private final RegisterUserEventNotificationService registerUserEventNotificationService;

    public String add(RegisterUserExample registerUserExample) {
        RegisterUser registerUser = RegisterUserFactory.createUser(registerUserExample);
        registerUserEventNotificationService.send(
                RegisterUserEventFactory.createEvent(registerUser, RegisterUserEventType.CREATE)
        );
        return registerUser.getId();
    }
}
