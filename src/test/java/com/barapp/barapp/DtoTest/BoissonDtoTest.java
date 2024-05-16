package com.barapp.barapp.DtoTest;

import com.barapp.barapp.Dto.BoissonDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoissonDtoTest {

    private BoissonDto boissonDto;

    @BeforeEach
    public void setUp() {
        boissonDto = new BoissonDto();
    }

    @Test
    public void testNom() {
        String nomValue = "Test Nom";
        boissonDto.setNom(nomValue);
        assertEquals(nomValue, boissonDto.getNom());
    }

    @Test
    public void testCategorieId() {
        Integer categorieIdValue = 1;
        boissonDto.setCategorieId(categorieIdValue);
        assertEquals(categorieIdValue, boissonDto.getCategorieId());
    }

    @Test
    public void testPrix() {
        List<Integer> prixValue = Arrays.asList(100, 200);
        boissonDto.setPrix(prixValue);
        assertEquals(prixValue, boissonDto.getPrix());
    }

    @Test
    public void testIngredientsListId() {
        List<Integer> ingredientsListIdValue = Arrays.asList(1, 2, 3);
        boissonDto.setIngredientsListId(ingredientsListIdValue);
        assertEquals(ingredientsListIdValue, boissonDto.getIngredientsListId());
    }
}