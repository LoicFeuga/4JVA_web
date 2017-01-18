package com.supinfo.webservices;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.supinfo.interfaces.InterfacesDao;
import com.supinfo.servlet.Index;


@WebService
@Path("/users")
public class UserService{

	@EJB
	InterfacesDao dao;

		
    @POST
    @Path("/login")
	@Produces("application/json")
    public String login(@FormParam("login") String login, @FormParam("mdp") String mdp) {
    	mdp = Index.aes_encrypt(mdp);
    	
    	//Boolean logged = true;
    	Boolean logged = dao.login(login, mdp);
    	System.out.println(logged);
    	return logged == null ? "false" : logged+"";


    	//return "a";
    }


}