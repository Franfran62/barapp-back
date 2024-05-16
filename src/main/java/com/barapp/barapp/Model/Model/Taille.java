package com.barapp.barapp.Model.Model;

public enum Taille {
    S, M, L;

    public static Taille getTailleByIndex(int index) {
        if (index >= 0 && index < values().length) {
            return values()[index];
        } else {
            throw new IndexOutOfBoundsException("La taille spécifiée est invalide.");
        }
    }
}
