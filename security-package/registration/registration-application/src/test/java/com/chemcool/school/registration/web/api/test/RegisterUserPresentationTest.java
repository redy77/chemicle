package com.chemcool.school.registration.web.api.test;

import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import com.chemcool.school.registration.web.api.service.RegisterUserPresentation;
import com.chemcool.school.registration.web.api.service.RegisterUserServiceLayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RegisterUserPresentationTest {
    @MockBean
    private RegisterUserServiceLayer registerUserServiceLayer;

    @Before
    public void sendRegisterUserPresentation() {
        this.registerUserServiceLayer = registerUserServiceLayer;
    }

    @Test
    public void add(){
        RegisterUserDto registerUserDto = new RegisterUserDto();
}
}
