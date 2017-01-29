package com.supinfo.manage;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.supinfo.interfaces.InterfacesDao;
import com.supinfo.servlet.Index;

@ManagedBean(name="cours")
@RequestScoped
public class CoursManage {
	
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	
	@EJB
	InterfacesDao dao;
	
	

}