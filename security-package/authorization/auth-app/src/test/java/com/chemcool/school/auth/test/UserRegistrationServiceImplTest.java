package com.chemcool.school.auth.test;

import com.chemcool.school.auth.service.domain.RegisterUser;
import com.chemcool.school.auth.service.service.UserRegistrationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

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