package com.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dao.UserDAO;
import com.mvc.model.Utilisateur;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 UserDAO us ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        us = new UserDAO() ;
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
		 HttpSession s = request.getSession() ;
		 String login = request.getParameter("login");
		 String mdp = request.getParameter("mdp");
		 List<Utilisateur> l = new ArrayList<>();
		 UserDAO us = new UserDAO() ;
		 Utilisateur u = us.getUtilisateur(login, mdp);
		 l.add(u);
		if(u!=null ) {
			request.setAttribute ( "user" , l.get(0));
			s.setAttribute("username", u.getEmail());
			s.setAttribute("id", u.getIdu());
            request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
		}
		else {
			request.setAttribute ( "msg" , "Login/MotDePasse Erroné!");
            request.getRequestDispatcher("/").forward(request, response);
		}
	}

}
