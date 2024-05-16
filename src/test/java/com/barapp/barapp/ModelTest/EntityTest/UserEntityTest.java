package com.barapp.barapp.ModelTest.EntityTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.barapp.barapp.Model.Entity.UserEntity;

import java.util.Date;

public class UserEntityTest {

    private UserEntity userEntity;

    @BeforeEach
    public void setUp() {
        userEntity = new UserEntity();
    }

    @Test
    public void testId() {
        Byte idValue = 1;
        userEntity.setId(idValue);
        assertEquals(idValue, userEntity.getId());
    }

    @Test
    public void testUsername() {
        String usernameValue = "Test Username";
        userEntity.setUsername(usernameValue);
        assertEquals(usernameValue, userEntity.getUsername());
    }

    @Test
    public void testPassword() {
        String passwordValue = "Test Password";
        userEntity.setPassword(passwordValue);
        assertEquals(passwordValue, userEntity.getPassword());
    }

    @Test
    public void testLastConnection() {
        Date dateValue = new Date();
        userEntity.setLastConnection(dateValue);
        assertEquals(dateValue, userEntity.getLastConnection());
    }

    @Test
    public void testToString() {
        String usernameValue = "Test Username";
        userEntity.setUsername(usernameValue);
        assertEquals("user=" + usernameValue + ".", userEntity.toString());
    }
}