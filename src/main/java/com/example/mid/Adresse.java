package com.example.mid;


import java.io.Serializable;

public class Adresse implements Serializable {
    private String rue;
    private String ville;
    private Personne personne;

    public Adresse(String rue, String ville, Personne personne) {
        this.rue = rue;
        this.ville = ville;
        this.personne = personne;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}