package com.supinfo.servlet;

import java.util.List;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.entity.Cours;
import com.supinfo.entity.User;
import com.supinfo.interfaces.InterfacesDao;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/Index")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(dao.getCours().size() == 0){
			dao.initCours();
		}
		

		String action = (String) request.getParameter("action");

		if ("go_signup".equals(action)) {
			request.setAttribute("login", false);
			System.out.println("\n request sent");
			request.getRequestDispatcher("/jsp/signup.jsp").forward(request, response);
		} else if ("go_cours".equals(action)) {
			List<Cours> list = (List<Cours>) dao.getCours();

			request.setAttribute("courses", list);
			request.getRequestDispatcher("/jsp/cours.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = (String) request.getParameter("login");
		String mdp = (String) request.getParameter("mdp");
		String action = (String) request.getParameter("action");

		// mdp = Index.aes_encrypt(mdp);
		System.out.println(action);

		if ("login".equals(action)) {
			Boolean ret = dao.login(login, mdp);
			if (!ret) {
				request.setAttribute("login", false);
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			}

		} else if ("signup".equals(action)) {

			String nom = (String) request.getParameter("nom");
			String prenom = (String) request.getParameter("prenom");
			Boolean ret = dao.signup(login, mdp, nom, prenom);
			if (!ret) {
				System.out.println("signup_go_login");
				request.setAttribute("login", false);
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			} else {
				List<Cours> list =  dao.getCours();
				request.getRequestDispatcher("/jsp/cours.jsp").forward(request, response);
			}
		}
		;

		// doGet(request, response);
	}

	public static String aes_encrypt(String password) {
		String strKey = "supinfo";
		try {
			byte[] keyBytes = Arrays.copyOf(strKey.getBytes("ASCII"), 16);

			SecretKey key = new SecretKeySpec(keyBytes, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);

			byte[] cleartext = password.getBytes("UTF-8");
			byte[] ciphertextBytes = cipher.doFinal(cleartext);

			return new String(ciphertextBytes, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
