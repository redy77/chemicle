package com.chemcool.school.auth.test;

import com.chemcool.school.auth.service.domain.RegisterUserEvent;
import com.chemcool.school.auth.service.domain.RegisterUserEventType;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class RegisterUserEventFactoryTest {
    RegisterUserEventType registerUserEventType=RegisterUserEventType.CREATE;
    RegisterUserEvent registerUserEvent = mock(RegisterUserEvent.class);

//    @Test
//    void createEvent(){
//        Mockito.when(registerUserEvent.createEvent(any(), any())).thenReturn(aRegisterUserEvent());
//        RegisterUser newRegisterUser = RegisterUser.builder().id("test_id").email("test_email")
//                .gender("test_gender").imageUrl("test_imageUrl").password("test_password")
//                .phone("test_phone").providerId("test_providerId").resetPasswordToken("test_resetPasswordToken")
//                .surname("test_surname").verificationCode("test_verificationCode").build();
//        RegisterUserEvent saveRegisterUserEvent = registerUserEvent.createEvent(newRegisterUser, registerUserEventType);
//
//        assertNotNull(saveRegisterUserEvent);
//        assertEquals(saveRegisterUserEvent.getEventId(), aRegisterUserEvent().getEventId());
//        assertEquals(saveRegisterUserEvent.getEventVersion(), aRegisterUserEvent().getEventVersion());
//        assertEquals(saveRegisterUserEvent.getAuthorId(), aRegisterUserEvent().getAuthorId());
//        assertEquals(saveRegisterUserEvent.getEntityId(), aRegisterUserEvent().getEntityId());
//        assertEquals(saveRegisterUserEvent.getOccurringContext(), aRegisterUserEvent().getOccurringContext());
//    }
}