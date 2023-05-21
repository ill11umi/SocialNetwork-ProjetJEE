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
 * Servlet implementation class searchFriends
 */
public class searchFriends extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchFriends() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession s = request.getSession();
    	String query = request.getParameter("query");
    	int id = (int) s.getAttribute("id");
    	

        
        UserDAO us = new UserDAO();
	    Utilisateur user = us.getUtilisateurById(id);
	    request.setAttribute("query", query);
    	

    	if(user!= null) {
            request.setAttribute ( "user" , user); 
            s.setAttribute("username", user.getEmail()); 
            
            request.getRequestDispatcher("/views/searchResults.jsp").forward(request, response);
        }
    	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
