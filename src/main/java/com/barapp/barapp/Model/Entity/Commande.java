package com.barapp.barapp.Model.Entity;

import com.barapp.barapp.Model.Model.Produit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "date", nullable = false)
    @NotNull(message = "La valeur n'est pas correcte")
    private Date date;

    @Column(name = "statut", length = 25)
    private String statut;

    @Column(name = "prix", nullable = false)
    @NotNull(message = "La valeur n'est pas correcte")
    @Min(value = 0, message = "Le prix ne peut pas être négatif")
    private Integer prix;

    @Column(name = "produits", nullable = false, length = 1000)
    private String produits;

    @NotNull(message = "La valeur n'est pas correcte")
    @Min(value = 0, message = "Le prix ne peut pas être négatif")
    private Integer NbProduit;

    public List<Produit> ConvertProduits() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List <Produit> produitList = objectMapper.readValue(produits, new TypeReference<List<Produit>>() {});
            return produitList;
        } catch (JsonProcessingException e)  {
            return null;
        }
    }

    public String getProduits() {
        return this.produits;
    }

    public void setProduits(List<Produit> produitsList) {
        ObjectMapper objectMapper = new ObjectMapper();
        try  {
            this.produits = objectMapper.writeValueAsString(produitsList);
        } catch (JsonProcessingException e) {
        }

    }
}
