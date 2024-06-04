package com.example.mid;

// AdresseDao.java
import java.io.PrintWriter;

public interface AdresseDao {
    int enregistrerAdresse(int id_carnet, String nomPersonne, Adresse adresse);
    int effacerAdresse(int id_carnet, String nomPersonne);
    Adresse chercherAdresse(int id_carnet, String nomPersonne);
    void listerAdresses(int id_carnet, PrintWriter out);
}