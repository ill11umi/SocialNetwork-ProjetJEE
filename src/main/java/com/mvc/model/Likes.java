package com.mvc.model;

public class Likes {
    private int idl;
    private int idu;
    private int idp;
    private String typeLike;

    public Likes(int idl, int idu, int idp, String typeLike) {
        this.idl = idl;
        this.idu = idu;
        this.idp = idp;
        this.typeLike = typeLike;
    }

    public Likes() {
		// TODO Auto-generated constructor stub
	}

	public int getIdl() {
        return idl;
    }

    public void setIdl(int idl) {
        this.idl = idl;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getTypeLike() {
        return typeLike;
    }

    public void setTypeLike(String typeLike) {
        this.typeLike = typeLike;
    }
}
