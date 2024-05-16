package com.barapp.barapp.Model.Model;

import lombok.Data;

@Data
public class Produit {

    private Integer idBoisson;
    private String nom;
    private String statut;
    private Taille taille;
    private Integer prix;
}
