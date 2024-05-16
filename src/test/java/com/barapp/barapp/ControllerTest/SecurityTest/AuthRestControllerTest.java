package com.barapp.barapp.ControllerTest;

import com.barapp.barapp.Controller.Security.AuthRestController;
import com.barapp.barapp.Dto.UserLoginDto;
import com.barapp.barapp.Model.Model.TokenStatus;
import com.barapp.barapp.Service.impl.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AuthRestControllerTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthRestController authRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin() {
        UserLoginDto userLoginDto = new UserLoginDto();
        when(authService.login(userLoginDto)).thenReturn("testToken");

        ResponseEntity<String> response = authRestController.login(userLoginDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("token"));
        assertTrue(response.getBody().contains("testToken"));
    }

    @Test
    public void testLoginWithIncorrectRequest() {
        UserLoginDto userLoginDto = new UserLoginDto();
        when(authService.login(userLoginDto)).thenReturn(null);

        ResponseEntity<String> response = authRestController.login(userLoginDto);

        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        assertEquals("{\"FORBIDDEN\":\"Vos données ne sont pas correctes\"}", response.getBody());
    }

    @Test
    public void testVerifyToken() {
        when(authService.verifyToken("testToken")).thenReturn(TokenStatus.Valid);

        ResponseEntity<String> response = authRestController.verifyToken("testToken");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("{\"status\":\"Valid\"}", response.getBody());
    }

    @Test
    public void testVerifyTokenWithNoToken() {
        when(authService.verifyToken(null)).thenReturn(null);

        ResponseEntity<String> response = authRestController.verifyToken(null);

        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        assertEquals("{\"FORBIDDEN\":\"Accès refusé\"}", response.getBody());
    }

    @Test
    public void testRefreshTokenWithValidData() {
        UserLoginDto userLoginDto = new UserLoginDto();
        when(authService.refreshToken(userLoginDto, "testToken")).thenReturn("newTestToken");

        ResponseEntity<String> response = authRestController.refreshToken(userLoginDto, "testToken");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("token"));
        assertTrue(response.getBody().contains("newTestToken"));
    }

    @Test
    public void testRefreshTokenWithInvalidData() {
        UserLoginDto userLoginDto = new UserLoginDto();
        when(authService.refreshToken(userLoginDto, "testToken")).thenReturn(null);

        ResponseEntity<String> response = authRestController.refreshToken(userLoginDto, "testToken");

        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        assertEquals("{\"FORBIDDEN\":\"Vos données ne sont pas correctes\"}", response.getBody());
    }

    @Test
    public void testRefreshTokenWithNoToken() {
        UserLoginDto userLoginDto = new UserLoginDto();
        when(authService.refreshToken(userLoginDto, null)).thenReturn(null);

        ResponseEntity<String> response = authRestController.refreshToken(userLoginDto, null);

        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        assertEquals("{\"FORBIDDEN\":\"Accès refusé\"}", response.getBody());
    }
}