package com.supinfo.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.supinfo.entity.Cours;
import com.supinfo.entity.User;
import com.supinfo.interfaces.InterfacesDao;
import com.supinfo.servlet.Index;

@ManagedBean(name="user")
@RequestScoped
public class UserManage {
	
	private int id;
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private Collection<Cours> cours;

	@EJB
	InterfacesDao dao;
	
	public String log(){
		mdp = Index.aes_encrypt(mdp);
		
		User user = dao.login(login, mdp);

		if(user != null){
			this.setId(user.getId());
			this.setCours(user.getCours());
			
			return "cours.xhtml";
		}else{
			login ="";
			mdp = "";
			return "login.xhtml";
		}
	}
	
	public String signup(){
		mdp = Index.aes_encrypt(mdp);

		if(dao.signup(login, mdp, nom, prenom)){
			return "cours.xhtml";
		}else{

			return "signup.xhtml";
		}
	}

	public String getLogin() {
		return login;
	}

	public String getMdp() {
		return mdp;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Cours> getCours() {
		return cours;
	}

	public void setCours(Collection<Cours> collection) {
		this.cours = collection;
	}
	
	

}