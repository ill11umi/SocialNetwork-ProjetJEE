package com.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.Instant;

import com.mvc.dao.UserDAO;
import com.mvc.model.Amis;
import com.mvc.model.Posts;
import com.mvc.model.Utilisateur;

/**
 * Servlet implementation class Suivre
 */
public class Suivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suivre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession s = request.getSession();
		String am = request.getParameter("ida");
		System.out.println(am);
		int ida = Integer.parseInt(am);
		int ids = (int) s.getAttribute("id");
		System.out.println("id"  + ids);
		UserDAO us = new UserDAO();
		
		Utilisateur u = us.getUtilisateurById(ids);
		Utilisateur t = us.getUtilisateurById(ida);
		Instant instant = Instant.now();
        java.sql.Timestamp timestamp = java.sql.Timestamp.from(instant);

        long timeMillis = timestamp.getTime(); 
        java.sql.Date date = new java.sql.Date(timeMillis);
        Amis m = new Amis ();
        m.setUtilisateur(u);
        m.setAmi(t);
        m.setDateAmitie(date);
        us.add(m);
		  if(u!= null) {
	            request.setAttribute ( "user" , u); 
	            s.setAttribute("username", u.getEmail()); 
	            request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
	        }
	}

}
