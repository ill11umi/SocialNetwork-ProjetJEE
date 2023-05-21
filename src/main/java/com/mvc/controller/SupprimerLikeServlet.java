package com.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.mvc.dao.UserDAO;

/**
 * Servlet implementation class SupprimerLikeServlet
 */
public class SupprimerLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerLikeServlet() {
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
	    // Récupère l'id de l'utilisateur et du poste depuis la requête AJAX
	    int idu = Integer.parseInt(request.getParameter("idu"));
	    int idp = Integer.parseInt(request.getParameter("idp"));

	    // Supprime tous les likes de l'utilisateur pour le post donné
	    UserDAO userDAO = new UserDAO();
	    try {
			userDAO.deleteLikesByIduAndIdp(idu, idp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Envoie la réponse à la requête AJAX
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write("Likes supprimés avec succès");
	}


}
