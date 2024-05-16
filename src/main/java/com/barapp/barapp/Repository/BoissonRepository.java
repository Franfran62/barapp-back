package com.barapp.barapp.Repository;

import com.barapp.barapp.Model.Entity.Boisson;
import com.barapp.barapp.Model.Entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoissonRepository extends JpaRepository<Boisson, Integer> {

    @Query("SELECT b FROM Boisson b WHERE b.honneur = true")
    List<Boisson> getAllSuggestion();
}
