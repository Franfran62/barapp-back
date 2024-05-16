package com.barapp.barapp.Repository;

import com.barapp.barapp.Model.Entity.Ingredient;
import com.barapp.barapp.Projection.ListeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    @Query("SELECT i FROM Ingredient i")
    List<ListeProjection> getListeOfIngredient();
}
