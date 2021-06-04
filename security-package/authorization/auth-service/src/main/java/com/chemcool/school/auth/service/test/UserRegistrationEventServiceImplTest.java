package com.chemcool.school.auth.service.test;

import com.chemcool.school.auth.service.domain.RegisterUserEvent;
import com.chemcool.school.auth.service.service.UserRegistrationEventServiceImpl;
import com.chemcool.school.auth.service.storage.RegisterUserEventRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static com.chemcool.school.auth.service.test.RegisterUserEventPrototype.aRegisterUserEvent;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class UserRegistrationEventServiceImplTest {

    @Test
    void saveEvent(){
        UserRegistrationEventServiceImpl registerUserEventService= mock(UserRegistrationEventServiceImpl.class);
        registerUserEventService.saveEvent(aRegisterUserEvent());
        verify(registerUserEventService, times(1)).saveEvent(isA(RegisterUserEvent.class));
    }
}