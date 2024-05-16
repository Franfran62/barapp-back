package com.barapp.barapp.ServiceTest;

import com.barapp.barapp.Dto.CommandeReadDto;
import com.barapp.barapp.Model.Entity.Commande;
import com.barapp.barapp.Model.Model.Produit;
import com.barapp.barapp.Model.Model.StatutCommande;
import com.barapp.barapp.Projection.CommandeClientProjection;
import com.barapp.barapp.Repository.CommandeRepository;
import com.barapp.barapp.Service.CommandeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CommandeServiceTest {

    @InjectMocks
    CommandeService commandeService;

    @Mock
    CommandeRepository commandeRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllForClient() {
        when(commandeRepository.getCommandesForClientView()).thenReturn(Arrays.asList(mock(CommandeClientProjection.class)));
        assertEquals(1, commandeService.getAllForClient().size());
    }

    @Test
    public void testGetAllForAdmin() {
        when(commandeRepository.findAll()).thenReturn(Arrays.asList(mock(Commande.class)));
        assertEquals(1, commandeService.getAllForAdmin().size());
    }

    @Test
    public void testGetOneById() {
        Commande commande = new Commande();
        commande.setPrix(10);
        commande.setDate(new Date());
        commande.setStatut(StatutCommande.EN_PREPARATION.getValue());
        commande.setProduits(Arrays.asList(new Produit()));
        commande.setNumero(1);

        when(commandeRepository.findById(1)).thenReturn(Optional.of(commande));

        Optional<CommandeReadDto> result = commandeService.getOneById(1);

        assertTrue(result.isPresent());
        assertEquals(commande.getPrix(), result.get().getPrix());
        assertEquals(commande.getDate(), result.get().getDate());
        assertEquals(commande.getStatut(), result.get().getStatut());
        assertEquals(commande.getProduits(), result.get().getProduits());
        assertEquals(commande.getNumero(), result.get().getNumero());
    }
}