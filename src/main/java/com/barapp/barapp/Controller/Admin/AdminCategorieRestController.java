package com.barapp.barapp.Controller.Admin;

import com.barapp.barapp.Dto.CategorieDto;
import com.barapp.barapp.Model.Entity.Categorie;
import com.barapp.barapp.Projection.ListeProjection;
import com.barapp.barapp.Service.impl.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/categorie")
public class AdminCategorieRestController {

    @Autowired
    private CategorieService categorieService;

    @PutMapping
    public ResponseEntity<Categorie> createOne(@RequestBody CategorieDto categorieDto) {
        return new ResponseEntity<>(categorieService.save(categorieDto), HttpStatus.CREATED) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> findById(@PathVariable Integer id) {
        Optional<Categorie> categorie = categorieService.getOneById(id);
        return new ResponseEntity<>(categorie.orElse(null), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return new ResponseEntity<Boolean>(categorieService.deleteById(id), HttpStatus.OK);
    }
}
