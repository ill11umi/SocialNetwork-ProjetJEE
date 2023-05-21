package com.mvc.model;

public class GroupeAmis {
    private int id;
    private Utilisateur utilisateur;

    public GroupeAmis() {}

    public GroupeAmis(int id, Utilisateur utilisateur) {
        this.setId(id);
        this.setUtilisateur(utilisateur);
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

    // Getters et setters
}