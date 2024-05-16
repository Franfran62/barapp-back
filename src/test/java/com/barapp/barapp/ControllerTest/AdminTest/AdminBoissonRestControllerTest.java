package com.barapp.barapp.ControllerTest;

import com.barapp.barapp.Controller.Admin.AdminBoissonRestController;
import com.barapp.barapp.Dto.BoissonDto;
import com.barapp.barapp.Model.Entity.Boisson;
import com.barapp.barapp.Service.impl.BoissonService;
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

public class AdminBoissonRestControllerTest {

    @Mock
    private BoissonService boissonService;

    @InjectMocks
    private AdminBoissonRestController adminBoissonRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateOneSuccess() {
        BoissonDto boissonDto = new BoissonDto();
        when(boissonService.save(boissonDto)).thenReturn(new Boisson());

        ResponseEntity<Boisson> response = adminBoissonRestController.createOne(boissonDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testPatchHonneurSuccess() {
        when(boissonService.patchHonneur(1)).thenReturn(true);

        ResponseEntity<Boolean> response = adminBoissonRestController.patchHonneur(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testFindByIdSuccess() {
        when(boissonService.getOneById(1)).thenReturn(Optional.of(new Boisson()));

        ResponseEntity<Boisson> response = adminBoissonRestController.findById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testDeleteByIdSuccess() {
        when(boissonService.deleteById(1)).thenReturn(true);

        ResponseEntity<Boolean> response = adminBoissonRestController.deleteById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}