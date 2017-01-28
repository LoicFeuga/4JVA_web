package com.supinfo.mock;

import java.util.ArrayList;
import java.util.List;

import com.supinfo.entity.Cours;
import com.supinfo.entity.User;

public class DaoMock {
	private List<User> allUsers;
	private List<Cours> allCours;
	
	
	public DaoMock(){
		allUsers = new ArrayList<User>();
		allUsers.add(new User("loic","loicmdp","Feuga","Loïc"));
		allUsers.add(new User("aziz","azizmdp","Liloudini","Aziz"));
		allUsers.add(new User("loic","loicmdp","Diakite","Mohamed"));
		allUsers.add(new User("loic","loicmdp","Tamakloe","Stephan"));
		
		allCours = new ArrayList<Cours>();
		allCours.add(new Cours("4VTZ","Virtualization",""));
		allCours.add(new Cours("4JVA","Java EE",""));
		allCours.add(new Cours("4VIP","Voice Over IP",""));
		allCours.add(new Cours("4MET","Method Agile Scrum",""));
		allCours.add(new Cours("4MOS","Microsoft Sharepoint",""));
	}
	
	public boolean login(String login, String mdp){
		for (int i = 0; i < allUsers.size(); i++) {
			User each = allUsers.get(i);
			if(each.getLogin().equals(login) && each.getMdp() == mdp){
				return true;
			}
		}
		
		return false;
		
	}
	public List<User> getUsers(){
		return allUsers;
		
	}
	public List<Cours> getCours(){
		return allCours;
		
	}
	private boolean isNull(String l){
		if(l == "" || l == null){
			return true;
		}
		
		return false;
	}
	public boolean signup(String login, String mdp, String nom, String prenom){
		if(isNull(login) || isNull(nom) || isNull(mdp) || isNull(prenom)){
			return false;
		}
		
		allUsers.add(new User(login,mdp,nom,prenom));
		
		return true;
		
	}

	public void initCours(){
		
	}
}
