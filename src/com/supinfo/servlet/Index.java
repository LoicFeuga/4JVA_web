package com.supinfo.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.interfaces.InterfacesDao;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	InterfacesDao dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao.getUsers();
		
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = (String)request.getParameter("login");
		String password = (String)request.getParameter("password");
		String action = (String)request.getParameter("submit");
						
		doGet(request, response);
	}

}
