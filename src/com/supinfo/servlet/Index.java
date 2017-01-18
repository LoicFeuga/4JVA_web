package com.supinfo.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao.getUsers();
		System.out.println(dao);

		request.setAttribute("login", false);
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = (String)request.getParameter("login");
		String password = (String)request.getParameter("mdp");
		String action = (String)request.getParameter("action");
				
		password = Index.aes_encrypt(password);

		
						
		//doGet(request, response);
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
	    } return null;
	}

	public String login(String login, String mdp) {
		Boolean logged = dao.login(login,mdp);
		
		return logged == null ? "false" : "true";
	}
}
