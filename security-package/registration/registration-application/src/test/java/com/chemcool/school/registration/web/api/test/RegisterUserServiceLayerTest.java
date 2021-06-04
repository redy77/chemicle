package com.chemcool.school.registration.web.api.test;

import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import com.chemcool.school.registration.web.api.service.RegisterUserServiceLayer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class RegisterUserServiceLayerTest {

private RegisterUserServiceLayer registerUserServiceLayer=mock(RegisterUserServiceLayer.class);
@Test
void add(){
    RegisterUserDto registerUserDto = mock(RegisterUserDto.class);
    String test = "test";
    when(registerUserServiceLayer.add(any(RegisterUserDto.class))).thenReturn(test);
    String chekTest = registerUserServiceLayer.add(registerUserDto);
    assertNotNull(chekTest);
    verify(registerUserServiceLayer, times(1)).add(registerUserDto);
}

}