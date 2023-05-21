package com.mvc.model;

import java.util.Date;

public class Invitation {
    private int id;
    private Utilisateur utilisateur;
    private Utilisateur invite;
    private Date dateInvitation;
    private Date dateAcceptation;
    private String status;

    public Invitation() {}

    public Invitation(int id, Utilisateur utilisateur, Utilisateur invite, Date dateInvitation, Date dateAcceptation, String status) {
        this.setId(id);
        this.setUtilisateur(utilisateur);
        this.setInvite(invite);
        this.setDateInvitation(dateInvitation);
        this.setDateAcceptation(dateAcceptation);
        this.setStatus(status);
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

	public Utilisateur getInvite() {
		return invite;
	}

	public void setInvite(Utilisateur invite) {
		this.invite = invite;
	}

	public Date getDateAcceptation() {
		return dateAcceptation;
	}

	public void setDateAcceptation(Date dateAcceptation) {
		this.dateAcceptation = dateAcceptation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateInvitation() {
		return dateInvitation;
	}

	public void setDateInvitation(Date dateInvitation) {
		this.dateInvitation = dateInvitation;
	}
    }
    


