package com.barapp.barapp.SecurityTest;

import com.barapp.barapp.Model.Entity.UserEntity;
import com.barapp.barapp.Model.Model.TokenStatus;
import com.barapp.barapp.Security.TokenGenerator;
import com.barapp.barapp.Service.IUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Key;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TokenGeneratorTest {

    @Mock
    private IUserService userService;

    @Mock
    private PasswordEncoder passwordEncoder;

    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    @InjectMocks
    private TokenGenerator tokenGenerator = new TokenGenerator(key);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGenerateToken() {
        UserEntity user = new UserEntity();
        user.setId(Byte.valueOf((byte) 1));
        user.setUsername("test@test.com");

        String token = tokenGenerator.generateToken(user);

        assertNotNull(token);
    }

    @Test
    public void testCheckCredentialsFailure() {
        UserEntity user = new UserEntity();
        user.setUsername("test@test.com");
        user.setPassword("password");

        when(userService.findByUsername(user.getUsername())).thenReturn(user);
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(false);

        UserEntity result = userService.checkCredentials(user.getUsername(), user.getPassword());

        assertNull(result);
    }

    @Test
    public void testVerifyToken() {
        UserEntity user = new UserEntity();
        user.setId(Byte.valueOf((byte) 1));
        user.setUsername("test@test.com");

        String token = tokenGenerator.generateToken(user);
        TokenStatus status = tokenGenerator.verifyToken(token);

        assertEquals(TokenStatus.Valid, status);
    }
}