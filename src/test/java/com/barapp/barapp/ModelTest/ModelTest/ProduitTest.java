package com.barapp.barapp.ModelTest.ModelTest;

import com.barapp.barapp.Model.Model.Produit;
import com.barapp.barapp.Model.Model.Taille;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProduitTest {

    private Produit produit;

    @BeforeEach
    public void setUp() {
        produit = new Produit();
    }

    @Test
    public void testIdBoisson() {
        Integer idBoissonValue = 1;
        produit.setIdBoisson(idBoissonValue);
        assertEquals(idBoissonValue, produit.getIdBoisson());
    }

    @Test
    public void testNom() {
        String nomValue = "Test Nom";
        produit.setNom(nomValue);
        assertEquals(nomValue, produit.getNom());
    }

    @Test
    public void testStatut() {
        String statutValue = "Test Statut";
        produit.setStatut(statutValue);
        assertEquals(statutValue, produit.getStatut());
    }

    @Test
    public void testTaille() {
        Taille tailleValue = Taille.L;
        produit.setTaille(tailleValue);
        assertEquals(tailleValue, produit.getTaille());
    }

    @Test
    public void testPrix() {
        Integer prixValue = 100;
        produit.setPrix(prixValue);
        assertEquals(prixValue, produit.getPrix());
    }
}