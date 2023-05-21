package com.mvc.controller;
  
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.util.Date;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mvc.dao.ConnexionBDD;
import com.mvc.dao.UserDAO;
import com.mvc.model.Utilisateur;
import com.mvc.model.Ville;
@MultipartConfig
/**
 * Servlet implementation class Inscrire
 */

public class Inscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 UserDAO us ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscrire() {
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
		
		  Part profileImgPart = request.getPart("ImgProfile");
			 String profileImgFileName = profileImgPart.getSubmittedFileName();
			 Path filePath = Paths.get(request.getServletContext().getRealPath("/ImagesProfil/"), profileImgFileName);
	            try (InputStream fileContent = profileImgPart.getInputStream()) {
	                Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
	            }
	            Part bannerImgPart = request.getPart("ImgBanniere");
	    	    String bannerImgFileName = bannerImgPart.getSubmittedFileName();
	    	    Path bannerImgPath = Paths.get(request.getServletContext().getRealPath("/ImagesProfil/"), bannerImgFileName);
		        try (InputStream bannerImgInputStream = bannerImgPart.getInputStream()) {
		            Files.copy(bannerImgInputStream, bannerImgPath, StandardCopyOption.REPLACE_EXISTING);
		    String Email = request.getParameter("Email");
		    String nom = request.getParameter("nom");
		    String prenom = request.getParameter("prenom");
		    String tel= request.getParameter("tel");
		    String date_naissance = request.getParameter("date_naissance");
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date date = null;
		    try {
		        date = dateFormat.parse(date_naissance);
		    } catch (ParseException e) {
		        // handle the parse exception here
		    }

		    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		    java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate1 = new java.sql.Date(utilDate.getTime());

		   


		    String mdp1 = request.getParameter("mdp1");
		    String mdp2 = request.getParameter("mdp2");
		    String ville = request.getParameter("ville");
		     System.out.println("testnomv: "  +ville);
		   
		    if(!mdp1.equals(mdp2) ) {
		        request.setAttribute ( "msg" , "les deux mots de passe ne correspond pas");
		        request.getRequestDispatcher("/").forward(request, response);
		    }
		    else {
		        Utilisateur u = new Utilisateur();
		        u.setNom(nom);
		        u.setPrenom(prenom);
		        u.setEmail(Email);
		        u.setTel(tel);
		        u.setMdp(mdp2);
		        u.setDateNaiss(sqlDate);
		        u.setProfilImg(profileImgFileName);
		        u.setBanniereImg(bannerImgFileName);
		        u.setEtatcpt(true);
		        u.setRole("user");
		        u.setRegDate(sqlDate1);
		       
		        Ville V = us.getVille(ville);

		        u.setVille(V);
		        us.save(u);
		        
		        request.setAttribute ( "msg" , "vous êtes inscrits avec succès, vous pouvez vous connecter maintenant");
                request.getRequestDispatcher("/").forward(request, response);
		        // Insert the user data into the database
		       
		    }
		}

	}
}

