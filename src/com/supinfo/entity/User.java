package com.supinfo.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


public class User implements Serializable{


	private int id;
	private String nom;

	private String prenom;
	
	private String login;
	
	private String mdp;

	private String token;

	private Collection<Cours> cours;

	private Collection<Certification> certifications;
	
	public User(){
		
	}
	
	public User(String login, String mdp, String nom, String prenom){
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getLogin() {
		return login;
	}

	public String getMdp() {
		return mdp;
	}

	public String getToken() {
		return token;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Collection<Cours> getCours() {
		return cours;
	}

	public Collection<Certification> getCertifications() {
		return certifications;
	}

	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}

	public void setCertifications(Collection<Certification> certifications) {
		this.certifications = certifications;
	}

}
