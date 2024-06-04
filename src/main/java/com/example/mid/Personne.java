package com.example.mid;

import java.io.Serializable;

public class Personne implements Serializable {

    private String nom;

    public Personne(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
