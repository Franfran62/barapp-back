package com.barapp.barapp.Service.impl;

import com.barapp.barapp.Dto.IngredientDto;
import com.barapp.barapp.Model.Entity.Ingredient;
import com.barapp.barapp.Projection.ListeProjection;
import com.barapp.barapp.Repository.IngredientRepository;
import com.barapp.barapp.Service.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService implements IGenericService<Ingredient, Integer> {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }
    @Override
    public Optional<Ingredient> getOneById(Integer id) {
        return ingredientRepository.findById(id);
    }
    public Ingredient save(IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setNom(ingredientDto.getNom());
        return ingredientRepository.save(ingredient);
    }
    @Override
    public Boolean deleteById(Integer id) {
        try {
            ingredientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<Ingredient> getByListById(List<Integer> idList) {
        List<Ingredient> ingredientList = new ArrayList<>();

        idList.forEach(id ->  {
            Optional<Ingredient> ingredient = ingredientRepository.findById(id);
            ingredient.ifPresent(ingredientList::add);
        });

        return ingredientList;
    }

    public List<ListeProjection> getListeOfIngredient() {
        return ingredientRepository.getListeOfIngredient();
    }
}
