package com.chemcool.school.registration.test;

import com.chemcool.school.registration.domain.RegisterUser;
import com.chemcool.school.registration.domain.RegisterUserEvent;
import com.chemcool.school.registration.domain.RegisterUserEventType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserEventTest {
    private RegisterUserEvent registerUserEvent;

    private RegisterUser registerUser;
    private RegisterUserEventType type;

    @Test
    void createEvent() {

    }
}