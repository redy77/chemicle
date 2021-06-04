package com.chemcool.school.auth.service.test;

import com.chemcool.school.auth.service.domain.RegisterUser;
import com.chemcool.school.auth.service.service.RegisterUserEventNotificationService;
import com.chemcool.school.auth.service.service.RegisterUserProxyService;
import com.chemcool.school.auth.service.storage.RegisterUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static com.chemcool.school.auth.service.test.RegistrationUserPrototype.aRegisterUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class RegisterUserProxyServiceTest {
    private RegisterUserProxyService registerUserProxyService = mock(RegisterUserProxyService.class);

    @Test
    void add (){
        when(registerUserProxyService.add(any())).thenReturn(aRegisterUser());
        RegisterUser newRegisterUser = RegisterUser.builder().email("test_email")
                .id("test_id").gender("test_gender").imageUrl("test_imageUrl").name("test_name")
                .password("test_password").phone("Test_phone")
                .providerId("test_providerId").surname("test_surname")
                .verificationCode("test_verificationCode").build();
        RegisterUser saveRegisterUser = registerUserProxyService.add(newRegisterUser);
        assertNotNull(saveRegisterUser);
        assertEquals(saveRegisterUser.getId(), aRegisterUser().getId());
        assertEquals(saveRegisterUser.getEmail(), aRegisterUser().getEmail());
        assertEquals(saveRegisterUser.getGender(), aRegisterUser().getGender());
        assertEquals(saveRegisterUser.getImageUrl(), aRegisterUser().getImageUrl());
        assertEquals(saveRegisterUser.getPassword(), aRegisterUser().getPassword());
        assertEquals(saveRegisterUser.getPhone(), aRegisterUser().getPhone());
        assertEquals(saveRegisterUser.getProviderId(), aRegisterUser().getProviderId());
        assertEquals(saveRegisterUser.getSurname(), aRegisterUser().getSurname());
        assertEquals(saveRegisterUser.getResetPasswordToken(), aRegisterUser().getResetPasswordToken());
        assertEquals(saveRegisterUser.getVerificationCode(), aRegisterUser().getVerificationCode());
        System.out.println("OK!");
    }
}