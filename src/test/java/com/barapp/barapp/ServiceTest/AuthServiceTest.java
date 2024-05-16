package com.barapp.barapp.Service.impl;

import com.barapp.barapp.Dto.UserLoginDto;
import com.barapp.barapp.Model.Entity.UserEntity;
import com.barapp.barapp.Model.Model.TokenStatus;
import com.barapp.barapp.Security.TokenGenerator;
import com.barapp.barapp.Service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private TokenGenerator tokenGenerator;

    @Mock
    private IUserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogin() {
        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setUsername("test");
        userLoginDto.setPassword("password");

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("test");

        when(userService.checkCredentials(userLoginDto.getUsername(), userLoginDto.getPassword())).thenReturn(userEntity);
        when(tokenGenerator.generateToken(userEntity)).thenReturn("token");

        String result = authService.login(userLoginDto);

        assertEquals("token", result);
        verify(userService, times(1)).updateLastConnection(userLoginDto.getUsername());
    }

    @Test
    public void testRefreshToken() {
        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setUsername("test");
        userLoginDto.setPassword("password");

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("test");

        when(tokenGenerator.verifyToken("oldToken")).thenReturn(TokenStatus.Expired);
        when(userService.checkCredentials(userLoginDto.getUsername(), userLoginDto.getPassword())).thenReturn(userEntity);
        when(tokenGenerator.generateToken(userEntity)).thenReturn("newToken");

        String result = authService.refreshToken(userLoginDto, "oldToken");

        assertEquals("newToken", result);
    }
}