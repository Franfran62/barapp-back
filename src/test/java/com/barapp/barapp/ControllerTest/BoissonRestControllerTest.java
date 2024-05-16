package com.barapp.barapp.ControllerTest;

import com.barapp.barapp.Controller.BoissonRestController;
import com.barapp.barapp.Model.Entity.Boisson;
import com.barapp.barapp.Service.impl.BoissonService;
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

public class BoissonRestControllerTest {

    @Mock
    private BoissonService boissonService;

    @InjectMocks
    private BoissonRestController boissonRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllBoisson() {
        Boisson boisson = new Boisson();
        boisson.setNom("Test Boisson");
        List<Boisson> boissons = Arrays.asList(boisson);

        when(boissonService.getAll()).thenReturn(boissons);

        ResponseEntity<List<Boisson>> response = boissonRestController.getAllBoisson();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(boissons, response.getBody());
    }
}