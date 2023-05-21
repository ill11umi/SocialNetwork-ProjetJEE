package com.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import com.mvc.dao.UserDAO;
import com.mvc.model.Posts;
import com.mvc.model.Utilisateur;


@MultipartConfig  
public class AddPostImageVid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostImageVid() {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession s = request.getSession() ;
    	String idu = request.getParameter("id");
    	int idk = Integer.parseInt(idu);
    	UserDAO us = new UserDAO();
        Utilisateur u = us.getUtilisateurById(idk);
    	String titre = request.getParameter("titre");

       
        Instant instant = Instant.now();
        System.out.println(titre);
        java.sql.Timestamp timestamp = java.sql.Timestamp.from(instant);

        long timeMillis = timestamp.getTime(); 
        java.sql.Date date = new java.sql.Date(timeMillis); 
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName(); // Extract the filename
        
    
      

       
        String contenu = fileName;
        
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1); 
       System.out.println(fileExtension);

        if ( (fileExtension.equals("jpg") || fileExtension.equals("png"))) {
            // Save the file as an image
        	
            Path filePath = Paths.get(request.getServletContext().getRealPath("/images/"), fileName);
            try (InputStream fileContent = filePart.getInputStream()) {
                Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
            }
            Posts p = new Posts();
            p.setUtilisateur(u);
            p.setTitle(titre);
            p.setContenu(contenu);
            p.setDatePoste(date);
            p.setTypePoste("image");
            us.savePost(p);
        } else if (  fileExtension.equals("mpk")) {
            // Save the file as a video
        	
            Path filePath = Paths.get(request.getServletContext().getRealPath("/videos/"), fileName);
            try (InputStream fileContent = filePart.getInputStream()) {
                Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
            }
            Posts p = new Posts();
            p.setUtilisateur(u);
            p.setTitle(titre);
            p.setContenu(contenu);
            p.setDatePoste(date);
            p.setTypePoste("video");
            us.savePost(p);
        } else {
            // Unsupported file type
            System.out.println("Unsupported file type.");
        }



        

        if(u!= null) {
            request.setAttribute ( "user" , u); 
            s.setAttribute("username", u.getEmail()); 
            request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
        }
        
	}

}
