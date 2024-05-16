package com.barapp.barapp.DtoTest;

import com.barapp.barapp.Dto.CommandeCreateDto;
import com.barapp.barapp.Model.Model.Produit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandeCreateDtoTest {

    private CommandeCreateDto commandeCreateDto;

    @BeforeEach
    public void setUp() {
        commandeCreateDto = new CommandeCreateDto();
    }

    @Test
    public void testPrix() {
        Integer prixValue = 100;
        commandeCreateDto.setPrix(prixValue);
        assertEquals(prixValue, commandeCreateDto.getPrix());
    }

    @Test
    public void testProduits() {
        List<Produit> produitsValue = Arrays.asList(new Produit(), new Produit());
        commandeCreateDto.setProduits(produitsValue);
        assertEquals(produitsValue, commandeCreateDto.getProduits());
    }
}