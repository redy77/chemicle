package com.chemcool.school.auth.test;

import com.chemcool.school.auth.service.domain.RegisterUser;
import com.chemcool.school.auth.service.service.RegisterUserProxyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

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
        when(registerUserProxyService.add(any())).thenReturn(RegistrationUserPrototype.aRegisterUser());
        RegisterUser newRegisterUser = new RegisterUser(
                "test_id",
                "test_email",
                "test_password",
                null,
                "test_name",
                "test_surname",
                null,
                "Test_phone",
                null,
                "test_gender",
                "test_imageUrl",
                null,
                "test_providerId",
                "test_verificationCode",
                true,
                null);

        RegisterUser saveRegisterUser = registerUserProxyService.add(newRegisterUser);
        assertNotNull(saveRegisterUser);
        Assertions.assertEquals(saveRegisterUser.getId(), RegistrationUserPrototype.aRegisterUser().getId());
        Assertions.assertEquals(saveRegisterUser.getEmail(), RegistrationUserPrototype.aRegisterUser().getEmail());
        Assertions.assertEquals(saveRegisterUser.getGender(), RegistrationUserPrototype.aRegisterUser().getGender());
        Assertions.assertEquals(saveRegisterUser.getImageUrl(), RegistrationUserPrototype.aRegisterUser().getImageUrl());
        Assertions.assertEquals(saveRegisterUser.getPassword(), RegistrationUserPrototype.aRegisterUser().getPassword());
        Assertions.assertEquals(saveRegisterUser.getPhone(), RegistrationUserPrototype.aRegisterUser().getPhone());
        Assertions.assertEquals(saveRegisterUser.getProviderId(), RegistrationUserPrototype.aRegisterUser().getProviderId());
        Assertions.assertEquals(saveRegisterUser.getSurname(), RegistrationUserPrototype.aRegisterUser().getSurname());
        Assertions.assertEquals(saveRegisterUser.getResetPasswordToken(), RegistrationUserPrototype.aRegisterUser().getResetPasswordToken());
        Assertions.assertEquals(saveRegisterUser.getVerificationCode(), RegistrationUserPrototype.aRegisterUser().getVerificationCode());
        System.out.println("OK!");
    }
}