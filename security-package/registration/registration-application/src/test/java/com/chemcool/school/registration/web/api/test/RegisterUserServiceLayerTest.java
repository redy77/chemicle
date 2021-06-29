package com.chemcool.school.registration.web.api.test;

import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import com.chemcool.school.registration.web.api.service.RegisterUserServiceLayer;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@Ignore
public class RegisterUserServiceLayerTest {

    private RegisterUserServiceLayer registerUserServiceLayer = mock(RegisterUserServiceLayer.class);

    @Test
    public void add() {
        RegisterUserDto registerUserDto = mock(RegisterUserDto.class);
        String test = "test";
        when(registerUserServiceLayer.add(any(RegisterUserDto.class))).thenReturn(test);
        String chekTest = registerUserServiceLayer.add(registerUserDto);
        assertNotNull(chekTest);
        verify(registerUserServiceLayer, times(1)).add(registerUserDto);
    }

}