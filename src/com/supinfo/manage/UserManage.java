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

import com.supinfo.entity.Certification;
import com.supinfo.entity.Cours;
import com.supinfo.entity.User;
import com.supinfo.interfaces.ICoursesDao;
import com.supinfo.interfaces.InterfacesDao;
import com.supinfo.servlet.Index;

@ManagedBean(name="user")
@RequestScoped
public class UserManage {
	
	private int id;
	private int logged = 0;
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private List<Cours> cours;
	private int icours;
	private User user;

	@EJB
	ICoursesDao daoC;
	@EJB
	InterfacesDao dao;
	
	public String log(){
		mdp = Index.aes_encrypt(mdp);
		
		User user = dao.login(login, mdp);

		if(user != null){
			this.setId(user.getId());
			this.setCours(user.getCours());
			loadCours();
			return "cours.xhtml";
		}else{
			login ="";
			mdp = "";
			logged = 1;
			return "login.xhtml";
		}
	}

	
	private void loadCours(){
		cours = dao.getCours();
		
//		List<Cours> allCours = new ArrayList<Cours>();
//		
//		user = daoC.findUserById(id);
//		
//		Collection<Certification> certifications = user.getCertifications();
//		Collection<Cours> coursesPassed = user.getCours();
//		
//
//		for(Certification certif : certifications){
//			Cours cours = certif.getCours();
//			cours.setType("certif");
//			allCours.add(cours);
//		}
//		
//		for(Cours passed : coursesPassed){
//			if(!allCours.contains(passed)){
//				Cours cours = passed;
//				cours.setType("passed");
//				allCours.add(cours);
//			}
//		}
//		
//		for(int i = 0; i < cours.size();i++){
//			Cours coursI = cours.get(i);
//			
//			if(!allCours.contains(cours)){
//				coursI.setType("no");
//				allCours.add(coursI);
//			}
//		}
//		
//		
//		cours = allCours;	
		
	}
	public String signup(){
		mdp = Index.aes_encrypt(mdp);

		if(dao.signup(login, mdp, nom, prenom)){
			return "cours.xhtml";
		}else{
			login = "";
			mdp = "";
			nom ="";
			prenom= "";
			logged = 1;
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
		this.cours = (List<Cours>) collection;
	}

	public int getLogged() {
		return logged;
	}

	public void setLogged(int logged) {
		this.logged = logged;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getIcours() {
		return icours;
	}

	public void setIcours(int icours) {
		this.icours = icours;
	}
	
	

}