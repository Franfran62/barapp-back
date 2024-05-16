package com.barapp.barapp.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(schema = "boisson")
public class Boisson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 50)
    @NotNull(message = "La valeur n'est pas correcte")
    private String nom;

    @Column(name = "honneur", nullable = false)
    @NotNull(message = "La valeur n'est pas correcte")
    private Boolean honneur;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categorie_id")
    @NotNull(message = "La valeur n'est pas correcte")
    @JsonIgnoreProperties("boissonsAttached")
    private Categorie categorie;

    @ManyToMany
    @JoinTable(name="ingredient_boisson",
            joinColumns = @JoinColumn(name="boisson_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id"))
    @JsonIgnoreProperties("boissonsAttached")
    private List<Ingredient> ingredients;

    @NotNull(message = "La valeur n'est pas correcte")
    private List<Integer> prix;

}

