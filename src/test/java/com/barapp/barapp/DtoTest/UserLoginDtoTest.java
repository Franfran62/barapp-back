package com.barapp.barapp.DtoTest;

import com.barapp.barapp.Dto.UserLoginDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserLoginDtoTest {

    private UserLoginDto userLoginDto;

    @BeforeEach
    public void setUp() {
        userLoginDto = new UserLoginDto();
    }

    @Test
    public void testUsername() {
        String usernameValue = "Test Username";
        userLoginDto.setUsername(usernameValue);
        assertEquals(usernameValue, userLoginDto.getUsername());
    }

    @Test
    public void testPassword() {
        String passwordValue = "Test Password";
        userLoginDto.setPassword(passwordValue);
        assertEquals(passwordValue, userLoginDto.getPassword());
    }
}