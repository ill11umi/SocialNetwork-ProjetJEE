package com.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;




import com.mvc.dao.UserDAO;
import com.mvc.model.Likes;

/**
 * Servlet implementation class AddLikeServlet
 */
public class AddLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLikeServlet() {
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
	        System.out.println(idu);
	        int idp = Integer.parseInt(request.getParameter("idp"));

	        // Ajoute le like à la base de données
	        Likes like = new Likes();
	        like.setIdu(idu);
	        like.setIdp(idp);
	        like.setTypeLike("like");
	        UserDAO us = new UserDAO();
	        us.saveLikes(like);

	       
	        List<Likes> likes = us.getAllLikesByIdp( idp);
	        int likeCount = likes.size();

	        // Envoie le nombre de likes en réponse à la requête AJAX
	        response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(String.valueOf(likeCount));
	    }
	}
	









