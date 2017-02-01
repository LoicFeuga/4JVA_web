package com.supinfo.manage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.supinfo.entity.Cours;
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
	
	
	
	@EJB
	InterfacesDao dao;

	public CoursManage(){
		courses = new ArrayList<Cours>();		
			
	}


	public String quizz(){
		return "login.xhtml";
		
//		FacesContext fc= FacesContext.getCurrentInstance();
//	    ExternalContext context=fc.getExternalContext();
//		    
//		Map<String, String> parameterMap = (Map<String, String>) context.getRequestParameterMap();
//		
//		String param = parameterMap.get("ids");
//		
//		System.out.println("i:"+param);

	}
	
	public void loadCours(){
		System.out.println("loadCours");
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
	
	

}