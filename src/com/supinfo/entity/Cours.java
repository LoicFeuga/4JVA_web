package com.supinfo.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class Cours implements Serializable {
	
	private int id;
	
	private String libelle;
	private String description;
	
	private String type;

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(String type) {
		this.type = type;
	}
}
