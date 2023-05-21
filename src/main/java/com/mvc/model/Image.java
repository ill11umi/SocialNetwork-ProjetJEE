package com.mvc.model;

public class Image {
    private int id;
    private String path;
    private String name;
    private Albums album;

    public Image() {}

    public Image(int id, String path, String name, Albums album) {
        this.setId(id);
        this.setPath(path);
        this.setName(name);
        this.setAlbum(album);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Albums getAlbum() {
		return album;
	}

	public void setAlbum(Albums album) {
		this.album = album;
	}

    // Getters et setters
}