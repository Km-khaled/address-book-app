package com.example.mid;

import java.io.PrintWriter;

public interface carnetDao {




    public  int creerCarnet(String nom) ;
    public  int supprimerCarnet(String nom) ;
    public  void listerCarnets(PrintWriter out) ;



    }
