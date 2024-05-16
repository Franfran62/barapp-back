// FILEPATH: /Users/franfran/Desktop/examen-1ere-annee/bar-app-back/src/test/java/com/barapp/barapp/ControllerTest/AdminIngredientRestControllerTest.java

package com.barapp.barapp.ControllerTest;

import com.barapp.barapp.Controller.Admin.AdminIngredientRestController;
import com.barapp.barapp.Dto.IngredientDto;
import com.barapp.barapp.Model.Entity.Ingredient;
import com.barapp.barapp.Service.impl.IngredientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AdminIngredientRestControllerTest {

    @Mock
    private IngredientService ingredientService;

    @InjectMocks
    private AdminIngredientRestController adminIngredientRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateOneSuccess() {
        IngredientDto ingredientDto = new IngredientDto();
        when(ingredientService.save(ingredientDto)).thenReturn(new Ingredient());

        ResponseEntity<Ingredient> response = adminIngredientRestController.createOne(ingredientDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testFindByIdSuccess() {
        when(ingredientService.getOneById(1)).thenReturn(Optional.of(new Ingredient()));

        ResponseEntity<Ingredient> response = adminIngredientRestController.findById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @Test
    public void testDeleteByIdSuccess() {
        when(ingredientService.deleteById(1)).thenReturn(true);

        ResponseEntity<Boolean> response = adminIngredientRestController.deleteById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}

