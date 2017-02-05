package com.supinfo.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class Cours implements Serializable{

	private int id;
	
	private String libelle;
	
	private String description;
	
	private String type;

	private Collection<Certification> certification;

	private Collection<Fichier> fichiers;

	private Collection<Question> questions;
	
	
	public Cours(){
		libelle = "";
		description ="";
		type ="";
	}
	
	public Cours(String libelle, String description, String type){
		this.libelle = libelle;
		this.description = description;
		this.type = type;
	}
	
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

	public Collection<Certification> getCertification() {
		return certification;
	}

	public Collection<Fichier> getFichiers() {
		return fichiers;
	}

	public Collection<Question> getQuestions() {
		return questions;
	}

	public void setCertification(Collection<Certification> certification) {
		this.certification = certification;
	}

	public void setFichiers(Collection<Fichier> fichiers) {
		this.fichiers = fichiers;
	}

	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}
	

}
