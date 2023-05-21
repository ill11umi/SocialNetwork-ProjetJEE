package com.mvc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.Date;

import com.mvc.model.Amis;
import com.mvc.model.Commentaire;
import com.mvc.model.Likes;
import com.mvc.model.Pays;
import com.mvc.model.Posts;
import com.mvc.model.Utilisateur;
import com.mvc.model.Ville;

import jakarta.servlet.ServletException;

public class UserDAO {
   public Utilisateur save(Utilisateur u) {
	   try {
           Connection conn = ConnexionBDD.getConnection();
           String query = "INSERT INTO utilisateur (nom, prenom, email, tel, dateNaiss , regDate, mdp, profilImg , banniereImg ,idville  ) VALUES (?, ?, ?, ?, ?, ?, ?, ? ,? , ?)";
           PreparedStatement stmt = conn.prepareStatement(query);
           stmt.setString(1, u.getNom());
           stmt.setString(2, u.getPrenom());
           stmt.setString(3, u.getEmail());
           stmt.setString(4, u.getTel());
           stmt.setDate(5, u.getDateNaiss());
           stmt.setString(7, u.getMdp());
           stmt.setString(8, u.getProfilImg());
           
          
           stmt.setString(9, u.getBanniereImg());
           stmt.setInt(10, u.getVille().getId());
           stmt.setDate(6, u.getRegDate());
           

           stmt.executeUpdate();
          ;
           
           conn.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
	   return u ;
   }
   public Likes saveLikes(Likes like) {
	    try {
	        Connection conn = ConnexionBDD.getConnection();
	        String query = "INSERT INTO likes (idp, idu, typeLike) VALUES (?, ?, ?)";
	        PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setInt(1, like.getIdp());
	        stmt.setInt(2, like.getIdu());
	        stmt.setString(3, like.getTypeLike());
	        stmt.executeUpdate();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return like;
	}
   public Commentaire saveCommentaire(int idu, int idp, String contenu) throws ServletException {
	    Commentaire commentaire = null;
	    try (Connection conn = ConnexionBDD.getConnection();
	         PreparedStatement statement = conn.prepareStatement(
	                 "INSERT INTO commentaire (idu, post_id, contenu) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
	        statement.setInt(1, idu);
	        statement.setInt(2, idp);
	        statement.setString(3, contenu);
	        statement.executeUpdate();

	       
	       
	    } catch (SQLException e) {
	        throw new ServletException("Unable to insert comment into database", e);
	    }
	    return commentaire;
	}

   public Posts savePost(Posts p) {
	    
	    try {
	        Connection conn = ConnexionBDD.getConnection();
	        String query = "INSERT INTO posts (idu ,title, contenu, datePoste , typeposte) VALUES (? ,?, ?, ? , ?)";
	        PreparedStatement stmt = conn.prepareStatement(query);
	        int l = p.getUtilisateur().getIdu() ;
	        stmt.setInt(1, l);
	        stmt.setString(2, p.getTitle());
	        stmt.setString(3, p.getContenu());
	        stmt.setDate(4, (Date) p.getDatePoste());
	        stmt.setString(5 , p.getTypePoste());
	        stmt.executeUpdate();

	        
	       

	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return p;
	}
   public Amis add(Amis m) {
       Connection conn = ConnexionBDD.getConnection();
       PreparedStatement stmt = null;
      
       try {
           String query = "INSERT INTO Amis (idu, idu_amis, dateAmitie) VALUES (?, ?, ?)";
           stmt = conn.prepareStatement(query);
           int l = m.getUtilisateur().getIdu() ;
           int s =  m.getAmi().getIdu() ;
           stmt.setInt(1, l);
           stmt.setInt(2, s);
           stmt.setDate(3, (Date) m.getDateAmitie());
           stmt.executeUpdate();
           

	      
	       
           conn.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
	return m;
		
   }

   
	   

	   

	    public List<Utilisateur> searchFriends(String name) {
	        List<Utilisateur> friends = new ArrayList<>();
	        Connection conn = ConnexionBDD.getConnection();
	        try {
	            String query = "SELECT * FROM utilisateur WHERE nom LIKE ?";
	            PreparedStatement statement = conn.prepareStatement(query);
	            statement.setString(1, "%" + name + "%");
	            ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	                Utilisateur user = new Utilisateur();
	                user.setIdu(resultSet.getInt("idu"));
	                System.out.println(resultSet.getInt("idu"));
	                user.setNom(resultSet.getString("nom"));
	                user.setPrenom(resultSet.getString("prenom"));
	                user.setProfilImg(resultSet.getString("profilImg"));
	                
	                
	                int idv = resultSet.getInt("idville");
	               
	                
	                Ville v = this.getVille(idv);
	                user.setVille(v);
	                
	                friends.add(user);
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return friends;
	    }
	


   public Ville getVille(int id) {
	   Connection conn = ConnexionBDD.getConnection();
   
	   PreparedStatement  stmt = null;
	   ResultSet rs = null;
	   Ville V = new Ville();
	   try {
          
           String query = "Select * from ville where idv = ?";
           
           stmt = conn.prepareStatement(query);
           stmt.setInt(1, id); // set the parameter value

           // 4. Execute the query
           rs = stmt.executeQuery();

           // 5. Process the result set
           while (rs.next()) {
               int idv = rs.getInt("idv");
               String villename = rs.getString("nomv");
               int idpays = rs.getInt("idp");
               V.setId(idv);
               V.setNom(villename);
               Pays p = this.getPays(idpays);
               V.setPays(p);
    
           }
           conn.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
	   return V;
   }
   
	   
   public List<Posts> getPosts(int id) {
	    Connection conn = ConnexionBDD.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    List<Posts> postList = new ArrayList<>();
	    
	    try {
	        String query = "SELECT * FROM posts WHERE idu = ?  ";
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, id);
	        rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            Posts P = new Posts();
	            int idp = rs.getInt("idp");
	            int idu = rs.getInt("idu");
	            P.setId(idp);
	            Utilisateur u = this.getUtilisateurById(idu);
	            P.setUtilisateur(u);
	            P.setContenu(rs.getString("contenu"));
	            P.setDatePoste(rs.getDate("datePoste"));
	            P.setTitle(rs.getString("title"));
	            P.setTypePoste(rs.getString("typeposte"));
	            
	            postList.add(P);
	        }
	        
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return postList;
	}
   public List<Posts> getAllPosts() {
       Connection conn = ConnexionBDD.getConnection();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       List<Posts> postList = new ArrayList<>();
       
       try {
           String query = "SELECT * FROM posts";
           stmt = conn.prepareStatement(query);
           rs = stmt.executeQuery();
           
           while (rs.next()) {
               Posts P = new Posts();
               int idp = rs.getInt("idp");
               int idu = rs.getInt("idu");
               P.setId(idp);
               Utilisateur u = this.getUtilisateurById(idu);
               P.setUtilisateur(u);
               P.setContenu(rs.getString("contenu"));
               P.setDatePoste(rs.getDate("datePoste"));
               P.setTitle(rs.getString("title"));
               P.setTypePoste(rs.getString("typeposte"));
               
               postList.add(P);
           }
     
           conn.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       
       return postList;
   }
   public List<Likes> getAllLikesByIdp(int idp) {
	    Connection conn = ConnexionBDD.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    List<Likes> likesList = new ArrayList<>();

	    try {
	        String query = "SELECT * FROM likes WHERE idp = ?";
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, idp);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            int idl = rs.getInt("idl");
	            int idu = rs.getInt("idu");
	            String typeLike = rs.getString("typeLike");
	            Likes like = new Likes(idl, idu, idp, typeLike);
	            likesList.add(like);
	        }
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return likesList;
	}

   public Posts getPostsbyid(int id) {
	    Connection conn = ConnexionBDD.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    Posts P = new Posts();
	    
	    
	    try {
	    	String query = "SELECT * FROM posts WHERE idp = ? ";

	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, id);
	        rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            
	            int idp = rs.getInt("idp");
	            int idu = rs.getInt("idu");
	            P.setId(idp);
	            Utilisateur u = this.getUtilisateurById(idu);
	            P.setUtilisateur(u);
	            P.setContenu(rs.getString("contenu"));
	            P.setDatePoste(rs.getDate("datePoste"));
	            P.setTitle(rs.getString("title"));
	            P.setTypePoste(rs.getString("typeposte"));
	            
	           
	        }
	        
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return P;
	}
  
   public List<Amis> getAmis(int id) {
	    List<Amis> amis = new ArrayList<>();
	    Connection conn = ConnexionBDD.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try {
	        String query = "SELECT * FROM amis WHERE idu = ?";
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, id);
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	            int amiId = rs.getInt("idu_amis");
	            Utilisateur utilisateur = this.getUtilisateurById(id);
	            Utilisateur ami = this.getUtilisateurById(amiId);
	            Date dateAmitie = rs.getDate("dateAmitie");
	            Amis amiObj = new Amis(rs.getInt("id"), utilisateur, ami, dateAmitie);
	            amis.add(amiObj);
	        }
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return amis;
	}
   public List<Likes> getLikesByIduAndIdp(int idu, int idp) {
	    List<Likes> likesList = new ArrayList<>();
	    Connection conn = ConnexionBDD.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try {
	        String query = "SELECT * FROM likes WHERE idu = ? AND idp = ?";
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, idu);
	        stmt.setInt(2, idp);
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	            int idl = rs.getInt("idl");
	            String typeLike = rs.getString("typeLike");
	            Likes like = new Likes(idl, idu, idp, typeLike);
	            likesList.add(like);
	        }
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return likesList;
	}
   public List<Commentaire> getCommentairesByIduAndPosteId(int idu, int posteId) {
	    List<Commentaire> commentairesList = new ArrayList<>();
	    Connection conn = ConnexionBDD.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try {
	        String query = "SELECT * FROM commentaire WHERE idu = ? AND post_id = ?";
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, idu);
	        stmt.setInt(2, posteId);
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	            int idc = rs.getInt("idc");
	            String contenu = rs.getString("contenu");
	            Utilisateur u = this.getUtilisateurById(idu);
	            Posts p = this.getPostsbyid(posteId);
	            Commentaire commentaire = new Commentaire(idc, u, p, contenu);
	            commentairesList.add(commentaire);
	        }
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return commentairesList;
	}

   public List<Commentaire> getAllCommentairesByIdp(int posteId) {
	    List<Commentaire> commentairesList = new ArrayList<>();
	    Connection conn = ConnexionBDD.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try {
	        String query = "SELECT * FROM commentaire WHERE post_id = ?";
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, posteId);
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	            int idc = rs.getInt("idc");
	            int idu = rs.getInt("idu");
	            String contenu = rs.getString("contenu");
	            Utilisateur u = this.getUtilisateurById(idu);
	            Posts p = this.getPostsbyid(posteId);
	            Commentaire commentaire = new Commentaire(idc, u, p, contenu);
	            commentairesList.add(commentaire);
	        }
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return commentairesList;
	}



   public Ville getVille(String idv) {
	   Connection conn = ConnexionBDD.getConnection();
   
	   PreparedStatement  stmt = null;
	   ResultSet rs = null;
	   Ville V = new Ville();
	   try {
          
           String query = "Select * from ville where nomv = ?";
           
           stmt = conn.prepareStatement(query);
           stmt.setString(1, idv); // set the parameter value

           // 4. Execute the query
           rs = stmt.executeQuery();

           // 5. Process the result set
           while (rs.next()) {
               int id = rs.getInt("idv");
               String villename = rs.getString("nomv");
               int idp = rs.getInt("idp");
               V.setId(id);
               V.setNom(villename);
               Pays p = this.getPays(idp);
               V.setPays(p);
    
           }
           conn.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
	   return V;
   }
   public Pays getPays(int idp) {
	   Connection conn = ConnexionBDD.getConnection();
   
	   PreparedStatement  stmt = null;
	   ResultSet rs = null;
	   Pays P = new Pays();
	   try {
          
           String query = "Select * from pays where nomp = ?";
           
           stmt = conn.prepareStatement(query);
           stmt.setInt(1, idp); // set the parameter value

           // 4. Execute the query
           rs = stmt.executeQuery();

           // 5. Process the result set
           while (rs.next()) {
               int idpp= rs.getInt("idv");
               String paysname = rs.getString("nomp");
               P.setId(idpp);
               P.setNom(paysname);
    
           }
           conn.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
	   return P;
   }
   public Utilisateur getUtilisateur (String username, String password ) {
	  
	   PreparedStatement stmt = null;
	   ResultSet rs = null;
	   Utilisateur u = null;
	  
	   try {
		   
		   Connection conne = ConnexionBDD.getConnection();
		  

	       String query = "SELECT * FROM utilisateur";
;
	       stmt = conne.prepareStatement(query);
	      
	       rs = stmt.executeQuery();
           while (rs.next()) {

        	   if (username.equals(rs.getString("email")) && password.equals(rs.getString("mdp"))) {
        	   u = new Utilisateur();
	           u.setIdu(rs.getInt("idu"));
	           u.setNom(rs.getString("nom"));
	           u.setPrenom(rs.getString("prenom"));
	           u.setEmail(rs.getString("email"));
	           u.setMdp(rs.getString("mdp"));
	           u.setRegDate(rs.getDate("regDate"));
	           
	       }
           }
	   } catch (SQLException e) {
	       // Handle the exception here
	   }
	   return u  ;
	   }
	      
   public Utilisateur getUtilisateurbyUsername (String username) {
		  
	   PreparedStatement stmt = null;
	   ResultSet rs = null;
	   Utilisateur u = null;
	  
	   try {
		   
		   Connection conne = ConnexionBDD.getConnection();
		  

	       String query = "SELECT * FROM utilisateur  WHERE email = ?";
;
	       stmt = conne.prepareStatement(query);
	      stmt.setString(1, username);
	       rs = stmt.executeQuery();
	      
           while (rs.next()) {
        	   u = new Utilisateur();
	           u.setIdu(rs.getInt("idu"));
	           u.setNom(rs.getString("nom"));
	           u.setPrenom(rs.getString("prenom"));
	           u.setEmail(rs.getString("email"));
	           u.setMdp(rs.getString("mdp"));
	           u.setRegDate(rs.getDate("regDate"));
	           u.setProfilImg(rs.getString("profilImg"));
	           u.setBanniereImg(rs.getString("banniereImg"));
	          
	           UserDAO us = new UserDAO() ;
	           Ville v = new Ville() ;
	           System.out.println(v.getNom());
	           v = us.getVille(rs.getInt("idville"));
	           u.setVille(v);
	           System.out.println(v.getNom());
	           
	       }
           
	   } catch (SQLException e) {
	       // Handle the exception here
	   }
	   return u  ;
	   }
     
	   
   public Utilisateur getUtilisateurById (int id) {
		  
	   PreparedStatement stmt = null;
	   ResultSet rs = null;
	   Utilisateur u = null;
	  
	   try {
		   
		   Connection conne = ConnexionBDD.getConnection();
		  

	       String query = "SELECT * FROM utilisateur  WHERE idu = ?";
;
	       stmt = conne.prepareStatement(query);
	      stmt.setInt(1, id);
	       rs = stmt.executeQuery();
	      
           while (rs.next()) {
        	   u = new Utilisateur();
	           u.setIdu(rs.getInt("idu"));
	           u.setNom(rs.getString("nom"));
	           u.setPrenom(rs.getString("prenom"));
	           u.setEmail(rs.getString("email"));
	           u.setMdp(rs.getString("mdp"));
	           u.setRegDate(rs.getDate("regDate"));
	           u.setProfilImg(rs.getString("profilImg"));
	           u.setBanniereImg(rs.getString("banniereImg"));
	          
	           UserDAO us = new UserDAO() ;
	           Ville v = new Ville() ;
	           System.out.println(v.getNom());
	           v = us.getVille(rs.getInt("idville"));
	           u.setVille(v);
	           System.out.println(v.getNom());
	           
	       }
           
	   } catch (SQLException e) {
	       // Handle the exception here
	   }
	   return u  ;
	   }
   public void updateUtilisateur(Utilisateur u) {
	    try {
	    	 Connection conne = ConnexionBDD.getConnection();
	        PreparedStatement ps = conne.prepareStatement("UPDATE utilisateur SET nom=?, prenom=?, email=?, mdp=?, profilImg=?, banniereImg=?  WHERE idu=?");
	        ps.setString(1, u.getNom());
	        ps.setString(2, u.getPrenom());
	        ps.setString(3, u.getEmail());
	        ps.setString(4, u.getMdp());
	        ps.setString(5, u.getProfilImg());
	        ps.setString(6, u.getBanniereImg());
	        ps.setInt(7, u.getIdu());
	        ps.executeUpdate();
	        conne.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
   public void deleteLikesByIduAndIdp(int idu, int idp) throws SQLException {
	    Connection conn = ConnexionBDD.getConnection();
	    PreparedStatement stmt = null;

	    try {
	        String query = "DELETE FROM likes WHERE idu = ? AND idp = ?";
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, idu);
	        stmt.setInt(2, idp);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // fermer le statement et la connexion
	        conn.close();
	    }
	}


	

	
	  
   
}

