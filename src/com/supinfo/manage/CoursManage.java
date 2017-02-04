package com.supinfo.manage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.supinfo.entity.Certification;
import com.supinfo.entity.Cours;
import com.supinfo.entity.User;
import com.supinfo.interfaces.ICoursesDao;
import com.supinfo.interfaces.ICoursesServices;
import com.supinfo.interfaces.InterfacesDao;
@ManagedBean(name="cours")
@RequestScoped
public class CoursManage {
	
	private int id;
	private String libelle;
	private String description;
	private String type;
	private boolean done;	
	private List<Cours> courses;
	private int icours;
	
	private User user;
	
	
	@EJB
	InterfacesDao dao;
	@EJB
	ICoursesDao daoC;

	public CoursManage(){
		courses = new ArrayList<Cours>();		
			
	}
	
	public void metho(){
		System.out.println(courses.toString());
	}
	
	@PostConstruct
	public void init(){
		courses = dao.getCours();
		
		List<Cours> allCours = new ArrayList<Cours>();

		//
		//int userID = userManage.getId() == 0 ? 1 : userManage.getId();
		
	//	user = daoC.findUserById(userID);
		
		Collection<Certification> certifications = user.getCertifications();
		Collection<Cours> coursesPassed = user.getCours();
		

		for(Certification certif : certifications){
			Cours cours = certif.getCours();
			cours.setType("certif");
			allCours.add(cours);
		}
		
		for(Cours passed : coursesPassed){
			if(!allCours.contains(passed)){
				Cours cours = passed;
				cours.setType("passed");
				allCours.add(cours);
			}
		}
		
		for(int i = 0; i < courses.size();i++){
			Cours cours = courses.get(i);
			
			if(!allCours.contains(cours)){
				cours.setType("no");
				allCours.add(cours);
			}
		}
		
		
		courses = allCours;
		
	}
	
	public void quizz(){
		daoC.addCours(new Cours("Cours "+icours,"Cours "+icours,""));		
	}
	
	public void loadCours(){
		courses = dao.getCours();
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


	public boolean isDone() {
		return done;
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


	public void setDone(boolean done) {
		this.done = done;
	}
	public List<Cours>getCourses() {
		return courses;
	}
	public void setCourses(List<Cours> courses) {
		this.courses = courses;
	}

	public int getIcours() {
		return icours;
	}

	public void setIcours(int icours) {
		this.icours = icours;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}