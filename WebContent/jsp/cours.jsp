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


        <title>Cours</title>
    </head>

    <body>
		    <% 	
	    		List<Cours> courses = new ArrayList<Cours>();
	    
				if((List<Object>) request.getAttribute("courses") != null){
					courses = (List<Cours>) request.getAttribute("courses");
				}
						
			%>
    	
    	  <nav class="teal lighten-3" style="">
		    <div class="nav-wrapper">
		      <a href="#" class="brand-logo">Supinfo courses</a>
		      <ul id="nav-mobile" class="right hide-on-med-and-down">		
		
			<c:forEach items="${courses}" var="cours">
			    <li>
			       <a href="coll.html"> <c:out value="${cours.libelle}"/></a>
			    </li>
			</c:forEach>
		      </ul>
		    </div>
		  </nav>
        
    	
		    	
	


			

	  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
   
 		<script src="<%=request.getContextPath()%>/js/common.js"></script>
    </body>

    </html>