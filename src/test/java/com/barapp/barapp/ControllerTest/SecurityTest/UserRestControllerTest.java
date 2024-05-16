package com.barapp.barapp.ControllerTest;

import com.barapp.barapp.Controller.Security.UserRestController;
import com.barapp.barapp.Dto.UserCreateDto;
import com.barapp.barapp.Model.Entity.UserEntity;
import com.barapp.barapp.Service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserRestControllerTest {

    @Mock
    private IUserService userService;

    @InjectMocks
    private UserRestController userRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUserSuccess() {
        UserCreateDto userDto = new UserCreateDto();
        when(userService.createUser(userDto)).thenReturn(true); // Remplacez User par le type de retour de votre méthode

        ResponseEntity<String> response = userRestController.createUser(userDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Création réussi", response.getBody());
    }

    @Test
    public void testCreateUserFailure() {
        UserCreateDto userDto = new UserCreateDto();
        doThrow(IllegalArgumentException.class).when(userService).createUser(userDto);

        ResponseEntity<String> response = userRestController.createUser(userDto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Impossible de créer un utilisateur", response.getBody());
    }
}