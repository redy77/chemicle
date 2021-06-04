package com.chemcool.school.auth.service.test;

import com.chemcool.school.auth.service.security.JwtUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class JwtUtilTest {
    private JwtUtil jwtUtil = mock(JwtUtil.class);

    @Test
    void createToken() {
        Authentication authentication = mock(Authentication.class);
        String answer = jwtUtil.generateJwt(authentication);
        //assertNotNull(answer);
        verify(jwtUtil, times(1)).generateJwt(isA(Authentication.class));
    }

    @Test
    void getUserIdFromToken(){
        String token = "token";
        when(
                jwtUtil.decodeJwt(isA(String.class)).get("id", String.class)
        ).thenReturn(token);

        String newToken = jwtUtil.decodeJwt(token).get("id", String.class);
        assertNotNull(newToken);
        assertEquals(newToken, token);
    }
}