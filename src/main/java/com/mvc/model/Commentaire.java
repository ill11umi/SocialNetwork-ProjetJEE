package com.mvc.model;

import java.util.Date;

public class Commentaire {
    private int idc;
    private Utilisateur utilisateur;
    private Posts post;
    private String contenu;
   

    public Commentaire() {}

    public Commentaire(int idc, Utilisateur utilisateur, Posts post, String contenu) {
        this.idc = idc;
        this.utilisateur = utilisateur;
        this.post = post;
        this.contenu = contenu;
        
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Posts getPost() {
        return post;
    }

    public void setPost(Posts post) {
        this.post = post;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    
}

