<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.supinfo.entity.*" %>
	
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


        <title>Cours</title>
    </head>

    <body>
    	
    	
		<% List<Cours> courses = (List<Cours>)request.getAttribute("courses");
		int i; 
		for(i = 0; i < courses.size();i++){
			out.print(courses.get(i).getLibelle());
			
		}
		
		%>
		    	
	


			

	  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
   
 		<script src="<%=request.getContextPath()%>/js/common.js"></script>
    </body>

    </html>