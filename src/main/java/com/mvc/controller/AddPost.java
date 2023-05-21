package com.mvc.controller;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.mvc.model.Posts;
import com.mvc.model.Utilisateur;
import com.mvc.dao.UserDAO;


public class AddPost extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAO us ;

    public AddPost() {
        super();
         us = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession s = request.getSession() ;
    	String idu = request.getParameter("id");
    	int idk = Integer.parseInt(idu);
    	UserDAO us = new UserDAO();
        Utilisateur u = us.getUtilisateurById(idk);
    	String titre = request.getParameter("titre");
        String contenu = request.getParameter("contenu");
        Instant instant = Instant.now();
        System.out.println(titre);
        java.sql.Timestamp timestamp = java.sql.Timestamp.from(instant);

        long timeMillis = timestamp.getTime(); 
        java.sql.Date date = new java.sql.Date(timeMillis); 


       
        Posts p = new Posts ();
        p.setUtilisateur(u);
        p.setTitle(titre);
        p.setContenu(contenu);
        p.setDatePoste(date);
        p.setTypePoste("message");
        us.savePost(p);
        
        if(u!= null) {
            request.setAttribute ( "user" , u); 
            s.setAttribute("username", u.getEmail()); 
            request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
        }
        
       

       
    }

}
