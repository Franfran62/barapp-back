package com.barapp.barapp.Model.Model;

public enum StatutBoisson {
    PREPARATION("Préparation des Ingrédients"), ASSEMBLAGE("Assemblage"), DRESSAGE("Dressage"), TERMINNE("Terminée");

    private final String value;

    private StatutBoisson(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String getValue(StatutBoisson statut) {
        return statut.value;
    }
}
