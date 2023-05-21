<%@ page import="com.mvc.model.Pays, com.mvc.dao.PaysDAO , com.mvc.model.Ville , com.mvc.dao.VilleDAO , com.mvc.model.Utilisateur, com.mvc.dao.ConnexionBDD, com.mvc.dao.UserDAO"   %><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%HttpSession s = request.getSession();
int id = (int) s.getAttribute("id");
  UserDAO us = new UserDAO();
	    Utilisateur user = us.getUtilisateurById(id);%>
  <jsp:include page="header.jsp"></jsp:include>
  <section class="profile-account-setting">
			<div class="container">
				<div class="account-tabs-setting">
					<div class="row">
						<div class="col-lg-3">
							<div class="acc-leftbar">
								<div class="nav nav-tabs" id="nav-tab" role="tablist">
								    <a class="nav-item nav-link active" id="nav-acc-tab" data-toggle="tab" href="#nav-acc" role="tab" aria-controls="nav-acc" aria-selected="true"><i class="la la-cogs"></i>changer la photo de profil et la banniere</a>
								    <a class="nav-item nav-link" id="nav-status-tab" data-toggle="tab" href="#nav-status" role="tab" aria-controls="nav-status" aria-selected="false"><i class="fa fa-line-chart"></i>Status</a>
								    <a class="nav-item nav-link" id="nav-password-tab" data-toggle="tab" href="#nav-password" role="tab" aria-controls="nav-password" aria-selected="false"><i class="fa fa-lock"></i>Changer le mot de passe</a>
								    <a class="nav-item nav-link" id="nav-notification-tab" data-toggle="tab" href="#nav-notification" role="tab" aria-controls="nav-notification" aria-selected="false"><i class="fa fa-flash"></i>Notifications</a>
								    <a class="nav-item nav-link" id="nav-requests-tab" data-toggle="tab" href="#nav-requests" role="tab" aria-controls="nav-requests" aria-selected="false"><i class="fa fa-group"></i>Invitation</a>
								    <a class="nav-item nav-link" id="security-login" data-toggle="tab" href="#security-login" role="tab" aria-controls="security-login" aria-selected="false"><i class="fa fa-user-secret"></i>Security and Login</a>
								    <a class="nav-item nav-link" id="privacy" data-toggle="tab" href="#privacy" role="tab" aria-controls="privacy" aria-selected="false"><i class="fa fa-paw"></i>Privacy</a>
								    <a class="nav-item nav-link" id="blockking" data-toggle="tab" href="#blockking" role="tab" aria-controls="blockking" aria-selected="false"><i class="fa fa-cc-diners-club"></i>Blocking</a>
								    <a class="nav-item nav-link" id="nav-deactivate-tab" data-toggle="tab" href="#nav-deactivate" role="tab" aria-controls="nav-deactivate" aria-selected="false"><i class="fa fa-random"></i>Désactiver le compte</a>
								  </div>
							</div><!--acc-leftbar end-->
						</div>
						<div class="col-lg-9">
							<div class="tab-content" id="nav-tabContent">
								<div class="tab-pane fade show active" id="nav-acc" role="tabpanel" aria-labelledby="nav-acc-tab">
									<div class="acc-setting">
										<h3>Changer la photo de profil</h3>
										<form action="/ProjetJ2E/ChangerPhotos"  method="post" enctype="multipart/form-data">
											<div class="notbar">
												<h4>Photo de Profil</h4>
												
												<div class="toggle-btn">
													<input type="file" name="imgProfile" class="form-control">
												</div>
											</div><!--notbar end-->
											<div class="notbar">
												<h4>photo de la banniere</h4>
												
												<div class="toggle-btn">
													<input type="file" name="imgBanniere" class="form-control">
												</div>
											</div><!--notbar end-->
											
											<div class="save-stngs">
												<ul>
													<li><button type="submit">Sauvegarder </button></li>
													<li><button type="submit">Annuler</button></li>
												</ul>
											</div><!--save-stngs end-->
										</form>
									</div><!--acc-setting end-->
								</div>
							  	<div class="tab-pane fade" id="nav-status" role="tabpanel" aria-labelledby="nav-status-tab">
							  		<div class="acc-setting">
							  			<h3>Changer le nom</h3>
							  			<div class="profile-bx-details">
							  				<div class="row">
							  					
							  					<form action="/ProjetJ2E/ChangerStatut" method="post">
							  					<label>Nom :</label>
							  					<input type="text" name="nom" class="form-control" value="<%=user.getNom()%>">
							  					<label>Prenom :</label>
							  					<input type="text" name="prenom" class="form-control" value="<%=user.getPrenom()%>">
							  					
							  					<div class="save-stngs">
												<ul>
													<li><button type="submit">Sauvegarder </button></li>
													<li><button type="submit">Annuler</button></li>
												</ul>
											</div><!--save-stngs end-->
							  					</form>	
							  				
							  				</div>
							  			</div><!--profile-bx-details end-->
							  			<div class="pro-work-status">
							  				<!-- <h4>Work Status  -  Last Months Working Status</h4> -->
							  			</div><!--pro-work-status end-->
							  		</div><!--acc-setting end-->
							  	</div>
							  	<div class="tab-pane fade" id="nav-password" role="tabpanel" aria-labelledby="nav-password-tab">
							  		<div class="acc-setting">
										<h3>Account Setting</h3>
										<form>
											<div class="cp-field">
												<h5>Old Password</h5>
												<div class="cpp-fiel">
													<input type="text" name="old-password" placeholder="Old Password">
													<i class="fa fa-lock"></i>
												</div>
											</div>
											<div class="cp-field">
												<h5>New Password</h5>
												<div class="cpp-fiel">
													<input type="text" name="new-password" placeholder="New Password">
													<i class="fa fa-lock"></i>
												</div>
											</div>
											<div class="cp-field">
												<h5>Repeat Password</h5>
												<div class="cpp-fiel">
													<input type="text" name="repeat-password" placeholder="Repeat Password">
													<i class="fa fa-lock"></i>
												</div>
											</div>
											<div class="cp-field">
												<h5><a href="#" title="">Forgot Password?</a></h5>
											</div>
											<div class="save-stngs pd2">
												<ul>
													<li><button type="submit">Save Setting</button></li>
													<li><button type="submit">Restore Setting</button></li>
												</ul>
											</div><!--save-stngs end-->
										</form>
									</div><!--acc-setting end-->
							  	</div>
							  	<div class="tab-pane fade" id="nav-notification" role="tabpanel" aria-labelledby="nav-notification-tab">
							  		<div class="acc-setting">
							  			<h3>Notifications</h3>
							  			<div class="notifications-list">
							  				<div class="notfication-details">
								  				<div class="noty-user-img">
								  					<img src="http://via.placeholder.com/35x35" alt="">
								  				</div>
								  				<div class="notification-info">
								  					<h3><a href="#" title="">Jassica William</a> Comment on your project.</h3>
								  					<span>2 min ago</span>
								  				</div><!--notification-info -->
							  				</div><!--notfication-details end-->
							  				<div class="notfication-details">
								  				<div class="noty-user-img">
								  					<img src="http://via.placeholder.com/35x35" alt="">
								  				</div>
								  				<div class="notification-info">
								  					<h3><a href="#" title="">Poonam Verma</a> Bid on your Latest project.</h3>
								  					<span>2 min ago</span>
								  				</div><!--notification-info -->
							  				</div><!--notfication-details end-->
							  				<div class="notfication-details">
								  				<div class="noty-user-img">
								  					<img src="http://via.placeholder.com/35x35" alt="">
								  				</div>
								  				<div class="notification-info">
								  					<h3><a href="#" title="">Tonney Dhman</a> Comment on your project.</h3>
								  					<span>2 min ago</span>
								  				</div><!--notification-info -->
							  				</div><!--notfication-details end-->
							  				<div class="notfication-details">
								  				<div class="noty-user-img">
								  					<img src="http://via.placeholder.com/35x35" alt="">
								  				</div>
								  				<div class="notification-info">
								  					<h3><a href="#" title="">Jassica William</a> Comment on your project.</h3>
								  					<span>2 min ago</span>
								  				</div><!--notification-info -->
							  				</div><!--notfication-details end-->
							  				<div class="notfication-details">
								  				<div class="noty-user-img">
								  					<img src="http://via.placeholder.com/35x35" alt="">
								  				</div>
								  				<div class="notification-info">
								  					<h3><a href="#" title="">Jassica William</a> Comment on your project.</h3>
								  					<span>2 min ago</span>
								  				</div><!--notification-info -->
							  				</div><!--notfication-details end-->
							  				<div class="notfication-details">
								  				<div class="noty-user-img">
								  					<img src="http://via.placeholder.com/35x35" alt="">
								  				</div>
								  				<div class="notification-info">
								  					<h3><a href="#" title="">Poonam Verma </a> Bid on your Latest project.</h3>
								  					<span>2 min ago</span>
								  				</div><!--notification-info -->
							  				</div><!--notfication-details end-->
							  				<div class="notfication-details">
								  				<div class="noty-user-img">
								  					<img src="http://via.placeholder.com/35x35" alt="">
								  				</div>
								  				<div class="notification-info">
								  					<h3><a href="#" title="">Tonney Dhman</a> Comment on your project</h3>
								  					<span>2 min ago</span>
								  				</div><!--notification-info -->
							  				</div><!--notfication-details end-->
							  				<div class="notfication-details">
								  				<div class="noty-user-img">
								  					<img src="http://via.placeholder.com/35x35" alt="">
								  				</div>
								  				<div class="notification-info">
								  					<h3><a href="#" title="">Jassica William</a> Comment on your project.</h3>
								  					<span>2 min ago</span>
								  				</div><!--notification-info -->
							  				</div><!--notfication-details end-->
							  			</div><!--notifications-list end-->
							  		</div><!--acc-setting end-->
							  	</div>
							  	<div class="tab-pane fade" id="nav-requests" role="tabpanel" aria-labelledby="nav-requests-tab">
							  		<div class="acc-setting">
							  			<h3>Requests</h3>
							  			<div class="requests-list">
							  				<div class="request-details">
							  					<div class="noty-user-img">
							  						<img src="http://via.placeholder.com/35x35" alt="">
							  					</div>
							  					<div class="request-info">
							  						<h3>Jessica William</h3>
							  						<span>Graphic Designer</span>
							  					</div>
							  					<div class="accept-feat">
							  						<ul>
							  							<li><button type="submit" class="accept-req">Accept</button></li>
							  							<li><button type="submit" class="close-req"><i class="la la-close"></i></button></li>
							  						</ul>
							  					</div><!--accept-feat end-->
							  				</div><!--request-detailse end-->
							  				<div class="request-details">
							  					<div class="noty-user-img">
							  						<img src="http://via.placeholder.com/35x35" alt="">
							  					</div>
							  					<div class="request-info">
							  						<h3>John Doe</h3>
							  						<span>PHP Developer</span>
							  					</div>
							  					<div class="accept-feat">
							  						<ul>
							  							<li><button type="submit" class="accept-req">Accept</button></li>
							  							<li><button type="submit" class="close-req"><i class="la la-close"></i></button></li>
							  						</ul>
							  					</div><!--accept-feat end-->
							  				</div><!--request-detailse end-->
							  				<div class="request-details">
							  					<div class="noty-user-img">
							  						<img src="http://via.placeholder.com/35x35" alt="">
							  					</div>
							  					<div class="request-info">
							  						<h3>Poonam</h3>
							  						<span>Wordpress Developer</span>
							  					</div>
							  					<div class="accept-feat">
							  						<ul>
							  							<li><button type="submit" class="accept-req">Accept</button></li>
							  							<li><button type="submit" class="close-req"><i class="la la-close"></i></button></li>
							  						</ul>
							  					</div><!--accept-feat end-->
							  				</div><!--request-detailse end-->
							  				<div class="request-details">
							  					<div class="noty-user-img">
							  						<img src="http://via.placeholder.com/35x35" alt="">
							  					</div>
							  					<div class="request-info">
							  						<h3>Bill Gates</h3>
							  						<span>C & C++ Developer</span>
							  					</div>
							  					<div class="accept-feat">
							  						<ul>
							  							<li><button type="submit" class="accept-req">Accept</button></li>
							  							<li><button type="submit" class="close-req"><i class="la la-close"></i></button></li>
							  						</ul>
							  					</div><!--accept-feat end-->
							  				</div><!--request-detailse end-->
							  				<div class="request-details">
							  					<div class="noty-user-img">
							  						<img src="http://via.placeholder.com/35x35" alt="">
							  					</div>
							  					<div class="request-info">
							  						<h3>Jessica William</h3>
							  						<span>Graphic Designer</span>
							  					</div>
							  					<div class="accept-feat">
							  						<ul>
							  							<li><button type="submit" class="accept-req">Accept</button></li>
							  							<li><button type="submit" class="close-req"><i class="la la-close"></i></button></li>
							  						</ul>
							  					</div><!--accept-feat end-->
							  				</div><!--request-detailse end-->
							  				<div class="request-details">
							  					<div class="noty-user-img">
							  						<img src="http://via.placeholder.com/35x35" alt="">
							  					</div>
							  					<div class="request-info">
							  						<h3>John Doe</h3>
							  						<span>PHP Developer</span>
							  					</div>
							  					<div class="accept-feat">
							  						<ul>
							  							<li><button type="submit" class="accept-req">Accept</button></li>
							  							<li><button type="submit" class="close-req"><i class="la la-close"></i></button></li>
							  						</ul>
							  					</div><!--accept-feat end-->
							  				</div><!--request-detailse end-->
							  			</div><!--requests-list end-->
							  		</div><!--acc-setting end-->
							  	</div>
							  	<div class="tab-pane fade" id="nav-deactivate" role="tabpanel" aria-labelledby="nav-deactivate-tab">
							  		<div class="acc-setting">
										<h3>Deactivate Account</h3>
										<form>
											<div class="cp-field">
												<h5>Email</h5>
												<div class="cpp-fiel">
													<input type="text" name="email" placeholder="Email">
													<i class="fa fa-envelope"></i>
												</div>
											</div>
											<div class="cp-field">
												<h5>Password</h5>
												<div class="cpp-fiel">
													<input type="password" name="password" placeholder="Password">
													<i class="fa fa-lock"></i>
												</div>
											</div>
											<div class="cp-field">
												<h5>Please Explain Further</h5>
												<textarea></textarea>
											</div>
											<div class="cp-field">
												<div class="fgt-sec">
													<input type="checkbox" name="cc" id="c4">
													<label for="c4">
														<span></span>
													</label>
													<small>Email option out</small>
												</div>
												<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus pretium nulla quis erat dapibus, varius hendrerit neque suscipit. Integer in ex euismod, posuere lectus id,</p>
											</div>
											<div class="save-stngs pd3">
												<ul>
													<li><button type="submit">Save Setting</button></li>
													<li><button type="submit">Restore Setting</button></li>
												</ul>
											</div><!--save-stngs end-->
										</form>
									</div><!--acc-setting end-->
							  	</div>
							</div>
						</div>
					</div>
				</div><!--account-tabs-setting end-->
			</div>
		</section>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="/ProjetJ2E/js/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="/ProjetJ2E/lib/slick/slick.min.js"></script>
<script type="text/javascript" src="/ProjetJ2E/js/script.js"></script>
</html>