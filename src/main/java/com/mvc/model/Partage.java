package com.mvc.model;

import java.util.Date;

public class Partage {
    private int id;
    private Utilisateur utilisateur;
    private Utilisateur utilisateurPartage;
    private Posts post;
    private Date datePartage;

    public Partage() {}

    public Partage(int id, Utilisateur utilisateur, Utilisateur utilisateurPartage, Posts post, Date datePartage) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.utilisateurPartage = utilisateurPartage;
        this.post = post;
        this.datePartage = datePartage;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Utilisateur getUtilisateurPartage() {
        return utilisateurPartage;
    }

    public Posts getPost() {
        return post;
    }

    public Date getDatePartage() {
        return datePartage;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setUtilisateurPartage(Utilisateur utilisateurPartage) {
        this.utilisateurPartage = utilisateurPartage;
    }

    public void setPost(Posts post) {
        this.post = post;
    }

    public void setDatePartage(Date datePartage) {
        this.datePartage = datePartage;
    }
}

