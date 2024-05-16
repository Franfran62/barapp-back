package com.barapp.barapp.DtoTest;

import com.barapp.barapp.Dto.CommandeReadDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandeReadDtoTest {

    private CommandeReadDto commandeReadDto;

    @BeforeEach
    public void setUp() {
        commandeReadDto = new CommandeReadDto();
    }

    @Test
    public void testNumero() {
        Integer numeroValue = 1;
        commandeReadDto.setNumero(numeroValue);
        assertEquals(numeroValue, commandeReadDto.getNumero());
    }

    @Test
    public void testDate() {
        Date dateValue = new Date();
        commandeReadDto.setDate(dateValue);
        assertEquals(dateValue, commandeReadDto.getDate());
    }

    @Test
    public void testStatut() {
        String statutValue = "Test Statut";
        commandeReadDto.setStatut(statutValue);
        assertEquals(statutValue, commandeReadDto.getStatut());
    }

    @Test
    public void testPrix() {
        Integer prixValue = 100;
        commandeReadDto.setPrix(prixValue);
        assertEquals(prixValue, commandeReadDto.getPrix());
    }

    @Test
    public void testProduits() {
        String produitsValue = "Test Produits";
        commandeReadDto.setProduits(produitsValue);
        assertEquals(produitsValue, commandeReadDto.getProduits());
    }
}