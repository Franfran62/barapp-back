package com.barapp.barapp.Repository;

import com.barapp.barapp.Model.Entity.Commande;
import com.barapp.barapp.Projection.CommandeClientProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    @Query("SELECT c.statut as statut, c.numero as numero FROM Commande c")
    List<CommandeClientProjection> getCommandesForClientView();

    @Override
    @Query("SELECT c FROM Commande c")
    List<Commande> findAll();
}
