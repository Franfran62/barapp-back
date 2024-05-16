package com.barapp.barapp.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategorieDto {

    @NotNull(message = "La valeur n'est pas correcte")
    @NotBlank(message = "La valeur n'est pas correcte")
    private String nom;
}
