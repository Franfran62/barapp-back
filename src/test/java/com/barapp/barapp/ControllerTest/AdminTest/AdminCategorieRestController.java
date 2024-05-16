package com.barapp.barapp.ControllerTest;

import com.barapp.barapp.Dto.CategorieDto;
import com.barapp.barapp.Model.Entity.Categorie;
import com.barapp.barapp.Service.impl.CategorieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AdminCategorieRestController {

    @Mock
    private CategorieService categorieService;

    @InjectMocks
    private com.barapp.barapp.Controller.Admin.AdminCategorieRestController adminCategorieRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateOneSuccess() {
        CategorieDto categorieDto = new CategorieDto();
        when(categorieService.save(categorieDto)).thenReturn(new Categorie());

        ResponseEntity<Categorie> response = adminCategorieRestController.createOne(categorieDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testFindByIdSuccess() {
        when(categorieService.getOneById(1)).thenReturn(Optional.of(new Categorie()));

        ResponseEntity<Categorie> response = adminCategorieRestController.findById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testDeleteByIdSuccess() {
        when(categorieService.deleteById(1)).thenReturn(true);

        ResponseEntity<Boolean> response = adminCategorieRestController.deleteById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}