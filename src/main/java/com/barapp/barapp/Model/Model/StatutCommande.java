package com.barapp.barapp.Model.Model;

public enum StatutCommande {
    COMMANDE("Commandée"),  EN_PREPARATION("En cours de préparation"), TERMINEE("Terminée");

    private final String value;

    private StatutCommande(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String getValue(StatutCommande statut) {
        return statut.value;
    }
}
