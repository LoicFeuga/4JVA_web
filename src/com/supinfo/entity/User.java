package com.supinfo.entity;

import java.io.Serializable;
import java.util.List;


public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String prenom;
	private String nom;
	
	private String mdp;
	private String login;
	
	private String token;

	public int getId() {
		return id;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getMdp() {
		return mdp;
	}

	public String getLogin() {
		return login;
	}

	public String getToken() {
		return token;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setToken(String token) {
		this.token = token;
	}



}
