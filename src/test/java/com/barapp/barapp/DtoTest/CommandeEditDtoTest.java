package com.barapp.barapp.DtoTest;

import com.barapp.barapp.Dto.CommandeEditDto;
import com.barapp.barapp.Model.Model.Produit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandeEditDtoTest {

    private CommandeEditDto commandeEditDto;

    @BeforeEach
    public void setUp() {
        commandeEditDto = new CommandeEditDto();
    }

    @Test
    public void testId() {
        Integer idValue = 1;
        commandeEditDto.setId(idValue);
        assertEquals(idValue, commandeEditDto.getId());
    }

    @Test
    public void testProduits() {
        List<Produit> produitsValue = Arrays.asList(new Produit(), new Produit());
        commandeEditDto.setProduits(produitsValue);
        assertEquals(produitsValue, commandeEditDto.getProduits());
    }
}