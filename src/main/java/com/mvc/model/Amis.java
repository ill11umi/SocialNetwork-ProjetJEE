package com.mvc.model;

import java.util.Date;

public class Amis {
    private int id;
    private Utilisateur utilisateur;
    private Utilisateur ami;
    private Date dateAmitie;

    public Amis() {}

    public Amis(int id, Utilisateur utilisateur, Utilisateur ami, Date dateAmitie) {
        this.setId(id);
        this.setUtilisateur(utilisateur);
        this.setAmi(ami);
        this.setDateAmitie(dateAmitie);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Utilisateur getAmi() {
		return ami;
	}

	public void setAmi(Utilisateur ami) {
		this.ami = ami;
	}

	public Date getDateAmitie() {
		return dateAmitie;
	}

	public void setDateAmitie(Date dateAmitie) {
		this.dateAmitie = dateAmitie;
	}

    // Getters et setters
}
