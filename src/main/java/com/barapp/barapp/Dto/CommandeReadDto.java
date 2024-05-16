package com.barapp.barapp.Dto;

import com.barapp.barapp.Model.Model.Produit;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CommandeReadDto {

    @NotNull(message = "La valeur n'est pas correcte")
    @Min(value = 0, message = "La valeur ne peut pas être négatif")
    private Integer numero;

    @NotNull(message = "La valeur n'est pas correcte")
    private Date date;

    @NotNull(message = "La valeur n'est pas correcte")
    @NotBlank(message = "La valeur n'est pas correcte")
    private String statut;

    @NotNull(message = "La valeur n'est pas correcte")
    @Min(value = 0, message = "La valeur ne peut pas être négatif")
    private Integer prix;

    @NotNull(message = "La valeur n'est pas correcte")
    private String produits;
}
