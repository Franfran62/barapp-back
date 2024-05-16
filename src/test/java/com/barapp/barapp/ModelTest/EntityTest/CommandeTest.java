package com.barapp.barapp.ModelTest.EntityTest;

import com.barapp.barapp.Model.Entity.Commande;
import com.barapp.barapp.Model.Model.Produit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandeTest {

    private Commande commande;

    @BeforeEach
    public void setUp() {
        commande = new Commande();
    }

    @Test
    public void testId() {
        Integer idValue = 1;
        commande.setId(idValue);
        assertEquals(idValue, commande.getId());
    }

    @Test
    public void testNumero() {
        Integer numeroValue = 123;
        commande.setNumero(numeroValue);
        assertEquals(numeroValue, commande.getNumero());
    }

    @Test
    public void testDate() {
        Date dateValue = new Date();
        commande.setDate(dateValue);
        assertEquals(dateValue, commande.getDate());
    }

    @Test
    public void testStatut() {
        String statutValue = "Test Statut";
        commande.setStatut(statutValue);
        assertEquals(statutValue, commande.getStatut());
    }

    @Test
    public void testPrix() {
        Integer prixValue = 100;
        commande.setPrix(prixValue);
        assertEquals(prixValue, commande.getPrix());
    }

    @Test
    public void testNbProduit() {
        Integer nbProduitValue = 5;
        commande.setNbProduit(nbProduitValue);
        assertEquals(nbProduitValue, commande.getNbProduit());
    }

    @Test
    public void testProduits() {
        List<Produit> produitsValue = Arrays.asList(new Produit(), new Produit());
        commande.setProduits(produitsValue);
        assertTrue(commande.ConvertProduits().size() == produitsValue.size());
    }
}