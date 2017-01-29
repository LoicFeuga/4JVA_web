<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.supinfo.entity.Cours" %>
	
    <!DOCTYPE html5>
    <html>

    <head>
  		
  		<!--  
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/materialize.min.css"/>		-->
 
  		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">

		<style type="text/css">
		    <%@include file="../css/material-icons.css" %>
		    <%@include file="../css/roboto.css" %>
		    <%@include file="../css/courses.css" %>
		</style>
		
		        
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />


        <title>Quizz</title>
    </head>

    <body>
		    <% 	
	    		List<Cours> courses = new ArrayList<Cours>();
	    
				if((List<Object>) request.getAttribute("courses") != null){
					courses = (List<Cours>) request.getAttribute("courses");
				}
						
			%>
    	
    	  <nav class="teal lighten-3">
		    <div class="nav-wrapper">
		      <a href="#" class="brand-logo center">Supinfo courses</a>
		      <ul id="nav-mobile" class="right hide-on-med-and-down">		
		
				<li><a href="Index">Déconnexion</a></li>
			
		      </ul>
		    </div>
		  </nav>
        
    	
			<div class="container">
				<div class="row">
				
					<h1>Passez le quizz</h1>
					
					<c:forEach items="${courses}" var="cours">
					    <div class="col s3">					    	
					    	<div class="cours">
					    		<c:out value="${cours.libelle}"/>
					    	</div>
					    	<div class="btn red vbutton">Suivre course</div>
					    </div>
					</c:forEach>
	
				</div>

			</div>

	  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
   
 		<script src="<%=request.getContextPath()%>/js/common.js"></script>
    </body>

    </html>