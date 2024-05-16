package com.barapp.barapp.ControllerTest;

import com.barapp.barapp.Controller.Admin.AdminCommandeRestController;
import com.barapp.barapp.Dto.CommandeEditDto;
import com.barapp.barapp.Dto.CommandeReadDto;
import com.barapp.barapp.Model.Entity.Commande;
import com.barapp.barapp.Service.CommandeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AdminCommandeRestControllerTest {

    @Mock
    private CommandeService commandeService;

    @InjectMocks
    private AdminCommandeRestController adminCommandeRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllForBarmaker() {
        List<Commande> commandes = Arrays.asList(mock(Commande.class));
        when(commandeService.getAllForAdmin()).thenReturn(commandes);

        ResponseEntity<List<Commande>> response = adminCommandeRestController.getAllForBarmaker();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(commandes, response.getBody());
    }

    @Test
    public void testGetCommandSuccess() {
        CommandeReadDto commandeReadDto = new CommandeReadDto();
        when(commandeService.getOneById(1)).thenReturn(Optional.of(commandeReadDto));

        ResponseEntity<CommandeReadDto> response = adminCommandeRestController.getCommand(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(commandeReadDto, response.getBody());
    }

    @Test
    public void testUpdateProduitsSuccess() {
        CommandeEditDto commandeEditDto = new CommandeEditDto();
        when(commandeService.updateProduits(commandeEditDto)).thenReturn(true);

        ResponseEntity<Boolean> response = adminCommandeRestController.updateProduits(commandeEditDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(true, response.getBody());
    }
}