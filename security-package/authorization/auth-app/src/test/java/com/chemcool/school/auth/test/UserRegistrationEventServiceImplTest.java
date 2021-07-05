package com.chemcool.school.auth.test;

import com.chemcool.school.auth.service.domain.RegisterUserEvent;
import com.chemcool.school.auth.service.service.UserRegistrationEventServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class UserRegistrationEventServiceImplTest {

    @Test
    void saveEvent(){
        UserRegistrationEventServiceImpl registerUserEventService= mock(UserRegistrationEventServiceImpl.class);
        registerUserEventService.saveEvent(RegisterUserEventPrototype.aRegisterUserEvent());
        verify(registerUserEventService, times(1)).saveEvent(isA(RegisterUserEvent.class));
    }
}