package com.mvc.controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.io.IOException;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.mvc.dao.UserDAO;
import com.mvc.model.Commentaire;
import com.mvc.model.Posts;
import com.mvc.model.Utilisateur;




public class AddCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   

        
        // TODO Auto-generated constructor stub
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession s = request.getSession();
    	int id = (int) s.getAttribute("id");
        int postId = Integer.parseInt(request.getParameter("postId"));
        String content = request.getParameter("content");

        // Get the user and post objects
        UserDAO us = new UserDAO();
       
        Utilisateur user = us.getUtilisateurById(id);
        Posts post = us.getPostsbyid(postId);
        

        // Create a new Commentaire object
        Commentaire commentaire = new Commentaire();
        commentaire.setPost(post);
        commentaire.setUtilisateur(user);
        
        commentaire.setContenu(content);

        // Insert the comment into the database
        us.saveCommentaire(user.getIdu(), post.getId(), content);

        // Update the comments list
        request.setAttribute("postId", postId);
        request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
    }
}

