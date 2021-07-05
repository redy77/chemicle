package com.chemcool.school.auth.test;
import com.chemcool.school.auth.service.domain.RegisterUserEvent;
import com.chemcool.school.auth.service.service.RegisterUserEventNotificationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class RegisterUserEventNotificationServiceImplTest {
    private RegisterUserEventNotificationServiceImpl registerUserEventNotificationService=mock(RegisterUserEventNotificationServiceImpl.class);
@Test
    void send(){
        registerUserEventNotificationService.send(RegisterUserEventPrototype.aRegisterUserEvent());
        verify(registerUserEventNotificationService, times(1)).send(isA(RegisterUserEvent.class));

    }

}