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


        <title>Signup</title>
    </head>

    <body>
    
    	
	
			<form id="form_signup" action="Index" method="GET" class="row form_signup">
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
				        <div class="input-field col s12">
				          <input id="prenom" name="prenom" type="text" class="validate">
				          <label for="prenom" style="text-align:left">Prénom</label>
				        </div>
				        
						<div class="input-field col s12">
				          <input id="nom" name="nom" type="password" class="validate">
				          <label for="nom" style="text-align:left">Nom</label>
				        </div>
				        
				        
					</div>			
									
					<div class="row">
						<a class="waves-effect waves-light btn-large" onclick='login()'><i class="material-icons left">send</i>Signup</a>
					</div>
					
					
					<div class="row">
						<div class="col s12">
						<h2 class="flow-text">Vous avez déjà un compte ?</h2>
						<a class="waves-effect" onclick='goLogin()'><i class="material-icons left">forward</i>Login</a>
					</div>
					</div>
				</div>
			</form>
			

	  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
   
 		<script src="<%=request.getContextPath()%>/js/common.js"></script>
 		<script src="<%=request.getContextPath()%>/js/signup.js"></script>
    </body>

    </html>