package com.barapp.barapp.DtoTest;

import com.barapp.barapp.Dto.IngredientDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientDtoTest {

    private IngredientDto ingredientDto;

    @BeforeEach
    public void setUp() {
        ingredientDto = new IngredientDto();
    }

    @Test
    public void testNom() {
        String nomValue = "Test Nom";
        ingredientDto.setNom(nomValue);
        assertEquals(nomValue, ingredientDto.getNom());
    }
}