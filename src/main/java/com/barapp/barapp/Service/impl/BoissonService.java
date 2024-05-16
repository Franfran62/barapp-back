package com.barapp.barapp.Service.impl;

import com.barapp.barapp.Dto.BoissonDto;
import com.barapp.barapp.Model.Entity.Boisson;
import com.barapp.barapp.Model.Entity.Categorie;
import com.barapp.barapp.Model.Entity.Ingredient;
import com.barapp.barapp.Repository.BoissonRepository;
import com.barapp.barapp.Service.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BoissonService implements IGenericService<Boisson, Integer> {

    @Autowired
    private BoissonRepository boissonRepository;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private IngredientService ingredientService;

    @Override
    public List<Boisson> getAll() {
        return boissonRepository.findAll();
    }

    @Override
    public Optional<Boisson> getOneById(Integer id) {
        return boissonRepository.findById(id);
    }

    public Boisson save(BoissonDto boissonDto) {

        Optional<Categorie> categorie = categorieService.getOneById(boissonDto.getCategorieId());
        List<Ingredient> ingredients = ingredientService.getByListById(boissonDto.getIngredientsListId());

        if (categorie.isEmpty() || ingredients.isEmpty()) {
            throw new NoSuchElementException("La valeur est incorrecte");
        }

        Boisson boisson = new Boisson();
        boisson.setNom(boissonDto.getNom());
        boisson.setHonneur(false);
        System.out.println(boisson);
        boisson.setPrix(boissonDto.getPrix());
        boisson.setCategorie(categorie.get());
        boisson.setIngredients(ingredients);

        return boissonRepository.save(boisson);
    }

    @Override
    public Boolean deleteById(Integer id) {
        try {
            boissonRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean patchHonneur(Integer id) {
        Optional<Boisson> boisson = this.getOneById(id);

        if (boisson.isPresent()) {
            Boisson boisson1 = boisson.get();
            boisson1.setHonneur(!boisson1.getHonneur());
            boissonRepository.save(boisson1);
            return true;
        }

        return false;
    }

    public List<Boisson> getAllSuggestion() {
        return boissonRepository.getAllSuggestion();
    }
}
