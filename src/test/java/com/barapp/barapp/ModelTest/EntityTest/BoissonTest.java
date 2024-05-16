package com.barapp.barapp.ModelTest.EntityTest;

import com.barapp.barapp.Model.Entity.Boisson;
import com.barapp.barapp.Model.Entity.Categorie;
import com.barapp.barapp.Model.Entity.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoissonTest {

    private Boisson boisson;

    @BeforeEach
    public void setUp() {
        boisson = new Boisson();
    }

    @Test
    public void testId() {
        Integer idValue = 1;
        boisson.setId(idValue);
        assertEquals(idValue, boisson.getId());
    }

    @Test
    public void testNom() {
        String nomValue = "Test Nom";
        boisson.setNom(nomValue);
        assertEquals(nomValue, boisson.getNom());
    }

    @Test
    public void testHonneur() {
        Boolean honneurValue = true;
        boisson.setHonneur(honneurValue);
        assertEquals(honneurValue, boisson.getHonneur());
    }

    @Test
    public void testCategorie() {
        Categorie categorieValue = new Categorie();
        boisson.setCategorie(categorieValue);
        assertEquals(categorieValue, boisson.getCategorie());
    }

    @Test
    public void testIngredients() {
        Ingredient ingredient1 = new Ingredient();
        Ingredient ingredient2 = new Ingredient();
        List<Ingredient> ingredientsValue = Arrays.asList(ingredient1, ingredient2);
        boisson.setIngredients(ingredientsValue);
        assertEquals(ingredientsValue, boisson.getIngredients());
    }

    @Test
    public void testPrix() {
        List<Integer> prixValue = Arrays.asList(10, 20);
        boisson.setPrix(prixValue);
        assertEquals(prixValue, boisson.getPrix());
    }
}