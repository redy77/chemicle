package com.chemcool.school.auth.service.test;

import com.chemcool.school.auth.service.domain.RegisterUser;
import com.chemcool.school.auth.service.service.RegisterUserProxyService;
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