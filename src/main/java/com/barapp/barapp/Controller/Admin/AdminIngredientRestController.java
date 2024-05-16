package com.barapp.barapp.Controller.Admin;

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
@RequestMapping("/api/admin/ingredient")
public class AdminIngredientRestController {

    @Autowired
    private IngredientService ingredientService;

    @PutMapping
    public ResponseEntity<Ingredient> createOne(@RequestBody IngredientDto ingredientDto) {
        return new ResponseEntity<>(ingredientService.save(ingredientDto), HttpStatus.CREATED) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> findById(@PathVariable Integer id) {
        Optional<Ingredient> ingredient = ingredientService.getOneById(id);
        return new ResponseEntity<>(ingredient.orElse(null), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return new ResponseEntity<Boolean>(ingredientService.deleteById(id), HttpStatus.OK);
    }
}
