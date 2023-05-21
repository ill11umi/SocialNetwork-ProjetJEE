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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.mvc.dao.UserDAO;
import com.mvc.model.Utilisateur;
@MultipartConfig  

public class ChangerPhotos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangerPhotos() {
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
	    HttpSession session = request.getSession();
	    int userId = (int) session.getAttribute("id");
	    UserDAO userDao = new UserDAO();
	    Utilisateur user = userDao.getUtilisateurById(userId);

	    Part profileImgPart = request.getPart("imgProfile");
	    String profileImgFileName = profileImgPart.getSubmittedFileName();
	    System.out.println("ll"+ profileImgFileName);
	    if (profileImgFileName != null && !profileImgFileName.isEmpty()) {
	    	 Path filePath = Paths.get(request.getServletContext().getRealPath("/images/"), profileImgFileName);
	            try (InputStream fileContent = profileImgPart.getInputStream()) {
	                Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
	            }
	        user.setProfilImg(profileImgFileName);
	    }

	    Part bannerImgPart = request.getPart("imgBanniere");
	    String bannerImgFileName = bannerImgPart.getSubmittedFileName();
	    if (bannerImgFileName != null && !bannerImgFileName.isEmpty()) {
	        Path bannerImgPath = Paths.get(request.getServletContext().getRealPath("/images/"), bannerImgFileName);
	        try (InputStream bannerImgInputStream = bannerImgPart.getInputStream()) {
	            Files.copy(bannerImgInputStream, bannerImgPath, StandardCopyOption.REPLACE_EXISTING);
	        }
	        user.setBanniereImg(bannerImgFileName);
	    }

	    userDao.updateUtilisateur(user);
	    session.setAttribute("username", user.getEmail());
	    request.setAttribute("user", user);
	    request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
	}
}
