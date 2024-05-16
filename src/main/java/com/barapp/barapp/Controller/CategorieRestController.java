package com.barapp.barapp.Controller;

import com.barapp.barapp.Dto.CategorieDto;
import com.barapp.barapp.Dto.IngredientDto;
import com.barapp.barapp.Model.Entity.Categorie;
import com.barapp.barapp.Model.Entity.Ingredient;
import com.barapp.barapp.Projection.ListeProjection;
import com.barapp.barapp.Service.impl.CategorieService;
import com.barapp.barapp.Service.impl.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorie")
public class CategorieRestController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public ResponseEntity<List<Categorie>> getAllCategorie(){
        return new ResponseEntity<>(categorieService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/liste")
    public ResponseEntity<List<ListeProjection>> getListOfCategorie(){
        return new ResponseEntity<>(categorieService.getListeOfCategorie(), HttpStatus.OK);
    }


}
