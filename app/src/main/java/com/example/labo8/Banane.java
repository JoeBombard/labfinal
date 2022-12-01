package com.example.labo8;

import java.io.Serializable;

public class Banane implements Serializable {
    private int unite;

    public int getUnite() {
        return unite;
    }

    public int getValeur() {
        return valeur;
    }

    private int valeur;

    public Banane(int unite, int valeur) {
        this.unite = unite;
        this.valeur = valeur;
    }
}
