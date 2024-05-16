package com.barapp.barapp.ModelTest.ModelTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.barapp.barapp.Model.Model.StatutBoisson;

public class StatutBoissonTest {

    @Test
    public void testPreparationValue() {
        assertEquals("Préparation des Ingrédients", StatutBoisson.PREPARATION.getValue());
    }

    @Test
    public void testAssemblageValue() {
        assertEquals("Assemblage", StatutBoisson.ASSEMBLAGE.getValue());
    }

    @Test
    public void testDressageValue() {
        assertEquals("Dressage", StatutBoisson.DRESSAGE.getValue());
    }

    @Test
    public void testTermineeValue() {
        assertEquals("Terminée", StatutBoisson.TERMINNE.getValue());
    }

    @Test
    public void testGetValue() {
        assertEquals("Assemblage", StatutBoisson.getValue(StatutBoisson.ASSEMBLAGE));
    }
}