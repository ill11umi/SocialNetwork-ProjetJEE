package com.mvc.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Utilisateur {
    private int idu;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private Date dateNaiss;
    private Date regDate;
    private String profilImg;
    private String banniereImg;
    private String status;
    private String mdp;
    private String role;
    private String question;
    private String reponse;
    private Ville ville;
    private boolean etatcpt;
    private List<Amis> amisesForIdu = new ArrayList<Amis>(0);
    private Set<Amis> amisesForIduAmis = new HashSet<Amis>(0);
    private Set<Albums> albumses= new HashSet<Albums>(0);
    private List<Posts> postes = new ArrayList<Posts>(0);
    private Set<Groupe> groupes= new HashSet<Groupe>(0);
    private Set<Partage> partageForIdu= new HashSet<Partage>(0);
    private Set<GroupeAmis> groupeamies= new HashSet<GroupeAmis>(0);
    private List<Invitation> invitationsForIduInvite = new ArrayList<Invitation>(0);
    private Set<Invitation> invitationsForIdu= new HashSet<Invitation>(0);
    private Set<Commentaire> commentaires= new HashSet<Commentaire>(0);
    private Set<Partage> partageForIduPartage = new HashSet<Partage>(0);
    private Set<Likes> likes = new HashSet<Likes>(0);
    public Utilisateur() {}

    public Utilisateur(String nom, String prenom, String email, String tel, Date dateNaiss, Date regDate,
                       String profilImg, String banniereImg, String status, String mdp, String role, String question,
                       String reponse, Ville ville, boolean etatcpt , List<Amis> amisesForIdu ,Set<Amis> amisesForIduAmis,
                       Set<Albums> albumses ,List<Posts> postes ,Set<Groupe> groupes , Set<Partage> partageForIdu , Set<GroupeAmis> groupeamies
                       , Set<Invitation> invitationsForIdu ,Set<Commentaire> commentaires,Set<Partage> partageForIduPartage , Set<Likes> likes ) {
       
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.dateNaiss = dateNaiss;
        this.regDate = regDate;
        this.profilImg = profilImg;
        this.banniereImg = banniereImg;
        this.status = status;
        this.mdp = mdp;
        this.role = role;
        this.question = question;
        this.reponse = reponse;
        this.ville = ville;
        this.etatcpt = etatcpt ;
        this.amisesForIdu = amisesForIdu ;
        this.amisesForIduAmis = amisesForIduAmis ;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getProfilImg() {
        return profilImg;
    }

    public void setProfilImg(String profilImg) {
    	this.profilImg = profilImg ;
    	}
    public String getBanniereImg() {
        return banniereImg;
    }
    public void setBanniereImg(String banniereImg) {
        this.banniereImg = banniereImg;
    }
    
 
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    

    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
   
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
 
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    
    
    public String getReponse() {
        return reponse;
    }
    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    
   
    public Ville getVille() {
        return ville;
    }
    public void setVille(Ville ville) {
    	this.ville = ville ;
    	
    }

	public boolean getEtatcpt() {
		return etatcpt;
	}

	public void setEtatcpt(boolean b) {
		this.etatcpt = b;
	}
     
	
	public List<Amis> getAmisesForIdu() {
		return amisesForIdu;
	}
    
	public void setAmisesForIdu(List<Amis> amisesForIdu) {
		this.amisesForIdu = amisesForIdu;
	}

	public Set<Amis> getAmisesForIduAmis() {
		return amisesForIduAmis;
	}

	public void setAmisesForIduAmis(Set<Amis> amisesForIduAmis) {
		this.amisesForIduAmis = amisesForIduAmis;
	}

	public Set<Albums> getAlbumses() {
		return albumses;
	}

	public void setAlbumses(Set<Albums> albumses) {
		this.albumses = albumses;
	}

	public Set<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(Set<Groupe> groupes) {
		this.groupes = groupes;
	}

	public List<Posts> getPostes() {
		return postes;
	}

	public void setPostes(List<Posts> postes) {
		this.postes = postes;
	}

	public Set<Partage> getPartageForIdu() {
		return partageForIdu;
	}

	public void setPartageForIdu(Set<Partage> partageForIdu) {
		this.partageForIdu = partageForIdu;
	}

	public List<Invitation> getInvitationsForIduInvite() {
		return invitationsForIduInvite;
	}

	public void setInvitationsForIduInvite(List<Invitation> invitationsForIduInvite) {
		this.invitationsForIduInvite = invitationsForIduInvite;
	}

	/**
	 * @return the groupeamies
	 */
	public Set<GroupeAmis> getGroupeamies() {
		return groupeamies;
	}

	/**
	 * @param groupeamies the groupeamies to set
	 */
	public void setGroupeamies(Set<GroupeAmis> groupeamies) {
		this.groupeamies = groupeamies;
	}

	/**
	 * @return the invitationsForIdu
	 */
	public Set<Invitation> getInvitationsForIdu() {
		return invitationsForIdu;
	}

	/**
	 * @param invitationsForIdu the invitationsForIdu to set
	 */
	public void setInvitationsForIdu(Set<Invitation> invitationsForIdu) {
		this.invitationsForIdu = invitationsForIdu;
	}

	/**
	 * @return the commentaires
	 */
	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}

	/**
	 * @param commentaires the commentaires to set
	 */
	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	/**
	 * @return the partageForIduPartage
	 */
	public Set<Partage> getPartageForIduPartage() {
		return partageForIduPartage;
	}

	/**
	 * @param partageForIduPartage the partageForIduPartage to set
	 */
	public void setPartageForIduPartage(Set<Partage> partageForIduPartage) {
		this.partageForIduPartage = partageForIduPartage;
	}

	/**
	 * @return the likes
	 */
	public Set<Likes> getLikes() {
		return likes;
	}

	/**
	 * @param likes the likes to set
	 */
	public void setLikes(Set<Likes> likes) {
		this.likes = likes;
	}

	
    
    }

