<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
    <!DOCTYPE html5>
    <html>

    <head>
  		
  		<!--  
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/materialize.min.css"/>		-->
 
  		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">

		<style type="text/css">
		    <%@include file="../css/material-icons.css" %>
		    <%@include file="../css/roboto.css" %>
		    <%@include file="../css/index.css" %>
		</style>
		
		        
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />


        <title>Log in</title>
    </head>

    <body>
    
    		
    		<c:if test="${login == false}">
    			<div class="row form_signup">
	    			Mauvaise combinaison id/password    			
    			</div>
    		</c:if>
	
			<form id="form_signup" action="Index" method="POST" class="row form_signup">
				<div class="col s12">
					<div class="row">
						<h1 class="flow-text">Sup Courses</h1>
					</div>
					<!-- Login -->
					<div class="row">
						<div class="input-field col s12">
				          <input id="login" name="login" type="text" class="validate">
				          <label for="login" style="text-align:left">Login</label>
				        </div>
				        
						<div class="input-field col s12">
				          <input id="mdp" name="mdp" type="password" class="validate">
				          <label for="mdp" style="text-align:left">Mot de passe</label>
				        </div>
				        
				        
				        <input id="action" name="action" type="text" style="display:none" value="login"/>
				        
					</div>			
									
					<div class="row">
						<button type="submit" class="waves-effect waves-light btn-large"><i class="material-icons left">send</i>Login</button>
					</div>
					
					
					<div  class="row">
						<div class="col s12">
						<h2 class="flow-text">Pas encore de compte ?</h2>
						<a id="goSignup" class="waves-effect"><i class="material-icons left">forward</i>Sign up</button>
					</div>
					</div>
				</div>
			</form>
			

	  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
   
 		<script src="<%=request.getContextPath()%>/js/common.js"></script>
 		<script src="<%=request.getContextPath()%>/js/soapclient.js"></script>
 		<script src="<%=request.getContextPath()%>/js/soap.js"></script>
 		<script src="<%=request.getContextPath()%>/js/login.js"></script>
    </body>

    </html>