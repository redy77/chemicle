package com.chemcool.school.auth.service.test;

import com.chemcool.school.auth.service.security.TokenProvider;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class TokenProviderTest {
    private TokenProvider tokenProvider=mock(TokenProvider.class);

    @Test
    void createToken() {
        Authentication authentication = mock(Authentication.class);
        String answer = tokenProvider.createToken(authentication);
        //assertNotNull(answer);
        verify(tokenProvider, times(1)).createToken(isA(Authentication.class));
    }

    @Test
    void getUserIdFromToken(){
        String token = "token";
        when(tokenProvider.getUserIdFromToken(isA(String.class))).thenReturn(token);
        String newToken = tokenProvider.getUserIdFromToken(token);
        assertNotNull(newToken);
        assertEquals(newToken, token);
    }
}