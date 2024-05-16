package com.barapp.barapp.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class BoissonDto {

    @NotNull(message = "La valeur n'est pas correcte")
    @NotBlank(message = "La valeur n'est pas correcte")
    private String nom;

    @NotNull(message = "La valeur n'est pas correcte")
    @Min(value = 0, message = "La valeur ne peut pas être négatif")
    private Integer categorieId;

    @NotNull(message = "La valeur n'est pas correcte")
    private List<Integer> prix;

    @NotNull(message = "La valeur n'est pas correcte")
    private List<Integer> ingredientsListId;
}
