package com.barapp.barapp.Service.impl;

import com.barapp.barapp.Dto.BoissonDto;
import com.barapp.barapp.Model.Entity.Boisson;
import com.barapp.barapp.Model.Entity.Categorie;
import com.barapp.barapp.Model.Entity.Ingredient;
import com.barapp.barapp.Repository.BoissonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BoissonServiceTest {

    @InjectMocks
    private BoissonService boissonService;

    @Mock
    private BoissonRepository boissonRepository;

    @Mock
    private CategorieService categorieService;

    @Mock
    private IngredientService ingredientService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        Boisson boisson = new Boisson();
        when(boissonRepository.findAll()).thenReturn(Arrays.asList(boisson));

        List<Boisson> result = boissonService.getAll();

        assertEquals(1, result.size());
        assertEquals(boisson, result.get(0));
    }

    @Test
    public void testGetOneById() {
        Boisson boisson = new Boisson();
        when(boissonRepository.findById(1)).thenReturn(Optional.of(boisson));

        Optional<Boisson> result = boissonService.getOneById(1);

        assertTrue(result.isPresent());
        assertEquals(boisson, result.get());
    }

    @Test
    public void testSave() {
        BoissonDto boissonDto = new BoissonDto();
        boissonDto.setCategorieId(1);
        boissonDto.setIngredientsListId(Arrays.asList(1, 2, 3));
        boissonDto.setNom("BoissonTest");
        boissonDto.setPrix(Arrays.asList(10, 20, 30));

        Categorie categorie = new Categorie();
        Ingredient ingredient = new Ingredient();

        when(categorieService.getOneById(1)).thenReturn(Optional.of(categorie));
        when(ingredientService.getByListById(Arrays.asList(1, 2, 3))).thenReturn(Arrays.asList(ingredient, ingredient, ingredient));

        Boisson boisson = new Boisson();
        boisson.setNom(boissonDto.getNom());
        boisson.setHonneur(false);
        boisson.setPrix(boissonDto.getPrix());
        boisson.setCategorie(categorie);
        boisson.setIngredients(Arrays.asList(ingredient, ingredient, ingredient));

        when(boissonRepository.save(any(Boisson.class))).thenReturn(boisson);

        Boisson result = boissonService.save(boissonDto);
        assertNotNull(result);
        assertEquals(boissonDto.getNom(), result.getNom());
        assertEquals(boissonDto.getPrix(), result.getPrix());
        assertEquals(categorie, result.getCategorie());
        assertEquals(3, result.getIngredients().size());
    }
}