package com.barapp.barapp.Repository;

import com.barapp.barapp.Model.Entity.Categorie;
import com.barapp.barapp.Projection.ListeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

    @Query("SELECT c FROM Categorie c")
    List<ListeProjection> getListeOfCategorie();
}
