package com.barapp.barapp.ControllerTest;

import com.barapp.barapp.Controller.IngredientRestController;
import static org.mockito.Mockito.*;
import com.barapp.barapp.Model.Entity.Ingredient;
import com.barapp.barapp.Projection.ListeProjection;
import com.barapp.barapp.Service.impl.IngredientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class IngredientRestControllerTest {

    @Mock
    private IngredientService ingredientService;

    @InjectMocks
    private IngredientRestController ingredientRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllIngredients() {
        Ingredient ingredient = new Ingredient();
        ingredient.setNom("Test Ingredient");
        List<Ingredient> ingredients = Arrays.asList(ingredient);

        when(ingredientService.getAll()).thenReturn(ingredients);

        ResponseEntity<List<Ingredient>> response = ingredientRestController.getAllIngredients();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ingredients, response.getBody());
    }

    @Test
    public void testGetListeOfIngredient() {
        ListeProjection listeProjection = mock(ListeProjection.class);
        when(listeProjection.getNom()).thenReturn("Test Ingredient");
        List<ListeProjection> listeProjections = Arrays.asList(listeProjection);

        when(ingredientService.getListeOfIngredient()).thenReturn(listeProjections);

        ResponseEntity<List<ListeProjection>> response = ingredientRestController.getListeOfIngredient();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listeProjections, response.getBody());
    }
}