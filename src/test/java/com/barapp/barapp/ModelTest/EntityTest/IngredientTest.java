package com.barapp.barapp.ModelTest.EntityTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.barapp.barapp.Model.Entity.Ingredient;
import com.barapp.barapp.Model.Entity.Boisson;

import java.util.Arrays;
import java.util.List;

public class IngredientTest {

    private Ingredient ingredient;

    @BeforeEach
    public void setUp() {
        ingredient = new Ingredient();
    }

    @Test
    public void testId() {
        Integer idValue = 1;
        ingredient.setId(idValue);
        assertEquals(idValue, ingredient.getId());
    }

    @Test
    public void testNom() {
        String nomValue = "Test Nom";
        ingredient.setNom(nomValue);
        assertEquals(nomValue, ingredient.getNom());
    }

    @Test
    public void testBoissonsAttached() {
        List<Boisson> boissons = Arrays.asList(new Boisson(), new Boisson());
        ingredient.setBoissonsAttached(boissons);
        assertEquals(boissons, ingredient.getBoissonsAttached());
    }
}