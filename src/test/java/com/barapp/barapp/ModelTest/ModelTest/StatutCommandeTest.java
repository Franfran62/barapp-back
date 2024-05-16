package com.barapp.barapp.ModelTest.ModelTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.barapp.barapp.Model.Model.StatutCommande;

public class StatutCommandeTest {

    @Test
    public void testCommandeValue() {
        assertEquals("Commandée", StatutCommande.COMMANDE.getValue());
    }

    @Test
    public void testEnPreparationValue() {
        assertEquals("En cours de préparation", StatutCommande.EN_PREPARATION.getValue());
    }

    @Test
    public void testTermineeValue() {
        assertEquals("Terminée", StatutCommande.TERMINEE.getValue());
    }

    @Test
    public void testGetValue() {
        assertEquals("Commandée", StatutCommande.getValue(StatutCommande.COMMANDE));
    }
}