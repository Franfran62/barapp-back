package com.barapp.barapp.Controller;

import com.barapp.barapp.Dto.IngredientDto;
import com.barapp.barapp.Model.Entity.Ingredient;
import com.barapp.barapp.Projection.ListeProjection;
import com.barapp.barapp.Service.impl.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientRestController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients(){
        return new ResponseEntity<>(ingredientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/liste")
    public ResponseEntity<List<ListeProjection>> getListeOfIngredient(){
        return new ResponseEntity<>(ingredientService.getListeOfIngredient(), HttpStatus.OK);
    }
}
