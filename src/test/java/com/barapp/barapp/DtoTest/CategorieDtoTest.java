package com.barapp.barapp.DtoTest;

import com.barapp.barapp.Dto.CategorieDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategorieDtoTest {

    private CategorieDto categorieDto;

    @BeforeEach
    public void setUp() {
        categorieDto = new CategorieDto();
    }

    @Test
    public void testNom() {
        String nomValue = "Test Nom";
        categorieDto.setNom(nomValue);
        assertEquals(nomValue, categorieDto.getNom());
    }
}