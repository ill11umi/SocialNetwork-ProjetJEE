package com.mvc.model;

public class Albums {
    private int id;
    private Utilisateur utilisateur;
    private String name;

    public Albums() {}

    public Albums(int id, Utilisateur utilisateur, String name) {
        this.setId(id);
        this.setUtilisateur(utilisateur);
        this.setName(name);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    // Getters et setters
}
