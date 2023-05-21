package com.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.mvc.dao.UserDAO;
import com.mvc.model.Utilisateur;

/**
 * Servlet implementation class ChangerStatut
 */
public class ChangerStatut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangerStatut() {
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
		HttpSession session = request.getSession();
	    int userId = (int) session.getAttribute("id");
	    UserDAO userDao = new UserDAO();
	    Utilisateur user = userDao.getUtilisateurById(userId);
	    String s = request.getParameter("nom");
	    String m = request.getParameter("prenom");
	    user.setNom(s);
	    user.setPrenom(m);
	    
	    userDao.updateUtilisateur(user);
	    session.setAttribute("username", user.getEmail());
	    request.setAttribute("user", user);
	    request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
	}

}
