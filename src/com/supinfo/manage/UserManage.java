package com.supinfo.manage;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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
	
	@EJB
	InterfacesDao dao;
	
	public void log(){
		mdp = Index.aes_encrypt(mdp);
		
		int loged = dao.login(login, mdp);

		if(loged > 0){
			this.id = loged;
			Index.redirect("cours.xhtml");
		}else{
			Index.redirect("login.xhtml");
		}
	}
	
	public void signup(){
		mdp = Index.aes_encrypt(mdp);

		if(dao.signup(login, mdp, nom, prenom)){
			Index.redirect("login.xhtml");
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
	
	

}