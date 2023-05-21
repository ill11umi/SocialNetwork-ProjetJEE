package com.mvc.model;


import java.util.ArrayList;
import java.util.Date;

import java.util.List;



public class Posts {
    private int id;
    private Utilisateur utilisateur;
    private String title;
    private String contenu;
    private Date datePoste;
    private String typePoste;
    private int state;
    private int nbrLikes;
    private int nbrDeslikes;
    
    private List<Commentaire> commentaires = new ArrayList<Commentaire>(0);
    private List<Likes> likes = new ArrayList<Likes>(0);

    public Posts() {}

    public Posts(int id, Utilisateur utilisateur, String title, String contenu, Date datePoste, String typePoste, int state, int nbrLikes, int nbrDeslikes
    		, List<Commentaire> commentaires , List<Likes> likes) {
        this.setId(id);
        this.setUtilisateur(utilisateur);
        this.setTitle(title);
        this.setContenu(contenu);
        this.setDatePoste(datePoste);
        this.setTypePoste(typePoste);
        this.setState(state);
        this.setNbrLikes(nbrLikes);
        this.setNbrDeslikes(nbrDeslikes);
        this.commentaires = commentaires ;
        this.likes = likes ;
        
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDatePoste() {
		return datePoste;
	}

	public void setDatePoste(Date datePoste) {
		this.datePoste = datePoste;
	}

	public String getTypePoste() {
		return typePoste;
	}

	public void setTypePoste(String typePoste) {
		this.typePoste = typePoste;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getNbrLikes() {
		return nbrLikes;
	}

	public void setNbrLikes(int nbrLikes) {
		this.nbrLikes = nbrLikes;
	}

	public int getNbrDeslikes() {
		return nbrDeslikes;
	}

	public void setNbrDeslikes(int nbrDeslikes) {
		this.nbrDeslikes = nbrDeslikes;
	}

	/**
	 * @return the commentaire
	 */


	/**
	 * @return the commentaires
	 */
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	/**
	 * @param commentaires the commentaires to set
	 */
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	/**
	 * @return the likes
	 */
	public List<Likes> getLikes() {
		return likes;
	}

	/**
	 * @param likes the likes to set
	 */
	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}

    // Getters et setters
}

