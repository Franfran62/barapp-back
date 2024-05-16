package com.barapp.barapp.ModelTest.CategorieTest;


import com.barapp.barapp.Model.Entity.Boisson;
import com.barapp.barapp.Model.Entity.Categorie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategorieTest {

    private Categorie categorie;

    @BeforeEach
    public void setUp() {
        categorie = new Categorie();
    }

    @Test
    public void testId() {
        Integer idValue = 1;
        categorie.setId(idValue);
        assertEquals(idValue, categorie.getId());
    }

    @Test
    public void testNom() {
        String nomValue = "Test Nom";
        categorie.setNom(nomValue);
        assertEquals(nomValue, categorie.getNom());
    }

    @Test
    public void testBoissonsAttached() {
        List<Boisson> boissons = Arrays.asList(new Boisson(), new Boisson());
        categorie.setBoissonsAttached(boissons);
        assertEquals(boissons, categorie.getBoissonsAttached());
    }
}