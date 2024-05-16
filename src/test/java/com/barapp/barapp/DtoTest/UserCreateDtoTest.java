package com.barapp.barapp.DtoTest;

import com.barapp.barapp.Dto.UserCreateDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserCreateDtoTest {

    private UserCreateDto userCreateDto;

    @BeforeEach
    public void setUp() {
        userCreateDto = new UserCreateDto();
    }

    @Test
    public void testUsername() {
        String usernameValue = "Test Username";
        userCreateDto.setUsername(usernameValue);
        assertEquals(usernameValue, userCreateDto.getUsername());
    }

    @Test
    public void testPassword() {
        String passwordValue = "Test Password";
        userCreateDto.setPassword(passwordValue);
        assertEquals(passwordValue, userCreateDto.getPassword());
    }
}