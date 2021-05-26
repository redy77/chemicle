package com.chemcool.school.auth.service.test;

import com.chemcool.school.auth.service.security.RestAuthenticationEntryPoint;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class RestAuthenticationEntryPointTest {
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint=mock(RestAuthenticationEntryPoint.class);

    @Test
    void commence() throws IOException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse=mock(HttpServletResponse.class);
        AuthenticationException e=mock(AuthenticationException.class);
        restAuthenticationEntryPoint.commence(httpServletRequest, httpServletResponse, e);
        verify(restAuthenticationEntryPoint, times(1))
                .commence(isA(HttpServletRequest.class), isA(HttpServletResponse.class), isA(AuthenticationException.class));
    }

}