package com.chemcool.school.auth.service.test;

import com.chemcool.school.auth.service.domain.RegisterUser;

public class RegistrationUserPrototype {

    public static RegisterUser aRegisterUser(){
        RegisterUser rUser = new RegisterUser();
        rUser.setId("test_id");
        rUser.setEmail("test_email");
        rUser.setPassword("test_password");
        rUser.setName("test_name");
        rUser.setEnabled(true);
        rUser.setSurname("test_surname");
        rUser.setPhone("test_phone");
        rUser.setGender("test_gender");
        rUser.setImageUrl("test_imageUrl");
        rUser.setProviderId("test_providerId");
        rUser.setResetPasswordToken("test_resetPasswordToken");
        return rUser;
    }
}
