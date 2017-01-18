package com.supinfo.webservices;

import javax.jws.WebService;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.supinfo.servlet.Index;

@WebService
@Path("/users")
public class UserService{



		
    @POST
    @Path("/login")
	@Produces("application/json")
    public String login(@FormParam("login") String login, @FormParam("mdp") String mdp) {
    	mdp = Index.aes_encrypt(mdp);
    	Boolean logged = true;//= dao.login(login, mdp);
    	
    	
    	return logged == null ? "false" : logged+"";


    	//return "a";
    }


}