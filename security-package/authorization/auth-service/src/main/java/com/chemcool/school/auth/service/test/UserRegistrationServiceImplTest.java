package com.chemcool.school.auth.service.test;

import com.chemcool.school.auth.service.domain.RegisterUser;
import com.chemcool.school.auth.service.service.UserRegistrationServiceImpl;
import com.chemcool.school.auth.service.storage.RegisterUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static com.chemcool.school.auth.service.test.RegistrationUserPrototype.aRegisterUser;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class UserRegistrationServiceImplTest {

    private UserRegistrationServiceImpl userRegistrationService=mock(UserRegistrationServiceImpl.class);

    @Test
    void save() {
        RegisterUser registerUser=mock(RegisterUser.class);
        userRegistrationService.save(registerUser);
        verify(userRegistrationService, times(1)).save(isA(RegisterUser.class));
    }
}