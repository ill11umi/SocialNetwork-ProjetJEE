<%@ page import="com.mvc.model.Pays, com.mvc.dao.PaysDAO , com.mvc.model.Ville , com.mvc.dao.VilleDAO , com.mvc.dao.ConnexionBDD"   %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
  <body class="sign-in">
  <jsp:include page="header.jsp"></jsp:include>
	

	<div class="wrapper">
		<div class="sign-in-page">
			<div class="signin-popup">
				<div class="signin-pop">
					<div class="row">
						<div class="col-lg-6">
							<div class="cmp-info">
							 <% if (request.getAttribute("msg") != null){ %>
							 <h4><%=request.getAttribute("msg") %></h4>
							 <% } %>
								<div class="cm-logo">
									<img src="images/cm-logo.png" alt="">
									<p>Ill11umi est une plateforme de médias sociaux innovante qui vise à connecter les utilisateurs du monde entier. Elle recommande des personnes et des groupes en fonction des intérêts de l'utilisateur, permet aux entreprises de promouvoir leurs produits et services, et offre une interface utilisateur simple et intuitive.</p>
								</div><!--cm-logo end-->	
								<img src="images/cm-main-img.png" alt="">			
							</div><!--cmp-info end-->
						</div>
						<div class="col-lg-6">
							<div class="login-sec">
								<ul class="sign-control">
									<li data-tab="tab-1" class="current"><a href="#" title="">Se connecter</a></li>				
									<li data-tab="tab-2"><a href="#" title="">S'inscrire</a></li>				
								</ul>			
								<div class="sign_in_sec current" id="tab-1">
									
									<h3>Login</h3>
									<form action="/ProjetJ2E/Login" method="post">
										<div class="row">
											<div class="col-lg-12 no-pdd">
												<div class="sn-field">
													<input type="text" name="login" placeholder="Username">
													<i class="la la-user"></i>
												</div><!--sn-field end-->
											</div>
											<div class="col-lg-12 no-pdd">
												<div class="sn-field">
													<input type="password" name="mdp" placeholder="Password">
													<i class="la la-lock"></i>
												</div>
											</div>
											<div class="col-lg-12 no-pdd">
												<div class="checky-sec">
													<div class="fgt-sec">
														<input type="checkbox" name="cc" id="c1">
														<label for="c1">
															<span></span>
														</label>
														<small>Remember me</small>
													</div><!--fgt-sec end-->
													<a href="#" title="">mot de passe oublié?</a>
												</div>
											</div>
											<div class="col-lg-12 no-pdd">
												<button type="submit" value="submit">login</button>
											</div>
										</div>
									</form>
									</div>
									
								<div class="sign_in_sec" id="tab-2">
									<div class="signup-tab">
										<i class="fa fa-long-arrow-left"></i>
										<h2>nom@example.com</h2>
										<ul>
											<li data-tab="tab-3" class="current"><a href="#" title="">User</a></li>
											
										</ul>
									</div><!--signup-tab end-->	
									<div class="dff-tab current" id="tab-3">
    <form action="/ProjetJ2E/Inscrire" method ="post" enctype="multipart/form-data">
    <div class="row">
        <div class="col-lg-6 no-pdd">
            <div class="sn-field">
                <input type="text" name="nom" placeholder="nom">
                <i class="la la-user"></i>
            </div>
        </div>
        <div class="col-lg-6 no-pdd">
            <div class="sn-field">
                <input type="text" name="prenom" placeholder="prenom">
                <i class="la la-globe"></i>
            </div>
        </div>
        <div class="col-lg-12 no-pdd">
            <div class="sn-field">
                <input type="text" name="Email" placeholder="Email">
                <i class="la la-mail-forward"></i>
            </div>
        </div>
        <div class="col-lg-12 no-pdd">
            <div class="sn-field">
                <input type="text" name="tel" placeholder="*tel">
                <i class="la la-globe"></i>
            </div>
        </div>
        <div class="col-lg-12 no-pdd">
            <div class="sn-field">
                <input type="file" name="ImgProfile" placeholder="ImageProfile">
                <i class="la la-globe"></i>
            </div>
        </div>
        <div class="col-lg-12 no-pdd">
            <div class="sn-field">
                <input type="file" name="ImgBanniere" placeholder="ImageBanniere">
                <i class="la la-globe"></i>
            </div>
        </div>
        <div class="col-lg-12 no-pdd">
            <div class="sn-field">
                <input type="date" name="date_naissance" placeholder="Date de naissance">
                <i class="la la-calendar"></i>
            </div>
        </div>
        <div class="col-lg-12 no-pdd">
            <div class="sn-field">
                <select name="ville" id="ville">
                    <option  value="">Sélectionner la ville/option>
                    <% 
                        List<Pays> paysList = new PaysDAO().getAllPays();
                        for (Pays pays : paysList) {
                            out.print("<option value=\"" + pays.getNom() + "\">" +"----"+ pays.getNom() + "----"+ "</option>");
                        
                       
                       
                            int idp =  pays.getId() ;
                            System.out.println("idp = " + idp); // affiche la valeur de idp dans la console
                            List<Ville> villeList = new VilleDAO().getVillesByPays(idp);
                            System.out.println("villeList.size() = " + villeList.size()); // affiche la taille de villeList dans la console
                            for (Ville ville : villeList) {
                                out.print("<option value=\"" + ville.getNom() + "\">" + ville.getNom() + "</option>");
                            }
                        }
                        

              %>
                   
                    
                </select>
                <i class="la la-globe"></i>
            </div>
        </div>
        <div class="col-lg-12 no-pdd">
            <div class="sn-field">
                <input type="password" name="mdp1" placeholder="Password">
                <i class="la la-lock"></i>
            </div>
        </div>
        <div class="col-lg-12 no-pdd">
            <div class="sn-field">
                <input type="password" name="mdp2" placeholder="Repeat Password">
                <i class="la la-lock"></i>
            </div>
        </div>
        <div class="col-lg-12 no-pdd">
			<button type="submit" value="submit">S'inscrire</button>
			</div>
        </div>
        </form>
        
          
										
								
									
			
			</div>
									
			</div><!--dff-tab end-->
			</div>		
			</div><!--login-sec end-->
			</div>
		    </div>		
		    </div><!--signin-pop end-->
			</div><!--signin-popup end-->
			</div>
			
			<jsp:include page="footer.jsp"></jsp:include>
			
		


</body>
</html>