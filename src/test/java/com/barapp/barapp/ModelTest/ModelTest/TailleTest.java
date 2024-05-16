package com.barapp.barapp.ModelTest.ModelTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.barapp.barapp.Model.Model.Taille;

public class TailleTest {

    @Test
    public void testPetiteValue() {
        assertEquals("S", Taille.S.name());
    }

    @Test
    public void testMoyenneValue() {
        assertEquals("M", Taille.M.name());
    }

    @Test
    public void testGrandeValue() {
        assertEquals("L", Taille.L.name());
    }
}