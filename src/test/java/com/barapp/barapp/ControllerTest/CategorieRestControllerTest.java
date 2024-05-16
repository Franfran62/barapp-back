package com.barapp.barapp.ControllerTest;

import com.barapp.barapp.Controller.CategorieRestController;
import com.barapp.barapp.Model.Entity.Categorie;
import com.barapp.barapp.Projection.ListeProjection;
import com.barapp.barapp.Service.impl.CategorieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CategorieRestControllerTest {

    @Mock
    private CategorieService categorieService;

    @InjectMocks
    private CategorieRestController categorieRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCategorie() {
        Categorie categorie = new Categorie();
        categorie.setNom("Test Categorie");
        List<Categorie> categories = Arrays.asList(categorie);

        when(categorieService.getAll()).thenReturn(categories);

        ResponseEntity<List<Categorie>> response = categorieRestController.getAllCategorie();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(categories, response.getBody());
    }

    @Test
    public void testGetListOfCategorie() {
        ListeProjection listeProjection = mock(ListeProjection.class);
        when(listeProjection.getNom()).thenReturn("Test Categorie");
        List<ListeProjection> listeProjections = Arrays.asList(listeProjection);

        when(categorieService.getListeOfCategorie()).thenReturn(listeProjections);

        ResponseEntity<List<ListeProjection>> response = categorieRestController.getListOfCategorie();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listeProjections, response.getBody());
    }
}