package com.barapp.barapp.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 50)
    @NotBlank(message = "La valeur n'est pas correcte")
    @NotNull(message = "La valeur n'est pas correcte")
    private String nom;

    @ManyToMany(mappedBy = "ingredients")
    @JsonIgnoreProperties({"ingredients", "categorie"})
    private List<Boisson> boissonsAttached;
}
