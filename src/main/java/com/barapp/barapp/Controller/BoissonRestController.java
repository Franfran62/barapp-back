package com.barapp.barapp.Controller;

import com.barapp.barapp.Dto.BoissonDto;
import com.barapp.barapp.Dto.CategorieDto;
import com.barapp.barapp.Model.Entity.Boisson;
import com.barapp.barapp.Model.Entity.Categorie;
import com.barapp.barapp.Service.impl.BoissonService;
import com.barapp.barapp.Service.impl.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boisson")
public class BoissonRestController {
    @Autowired
    private BoissonService boissonService;

    @GetMapping
    public ResponseEntity<List<Boisson>> getAllBoisson(){
        return new ResponseEntity<>(boissonService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/suggestion")
    public ResponseEntity<List<Boisson>> getAlBoissonSuggestion(){
        return new ResponseEntity<>(boissonService.getAllSuggestion(), HttpStatus.OK);
    }

}
