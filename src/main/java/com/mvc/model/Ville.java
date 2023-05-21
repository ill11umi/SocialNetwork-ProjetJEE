package com.mvc.model;

public class Ville {
    private int id;
    private String nom;
    private Pays pays;

    public Ville() {}

    public Ville(int id, String nom, Pays pays) {
        this.id = id;
        this.nom = nom;
        this.pays = pays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
}

