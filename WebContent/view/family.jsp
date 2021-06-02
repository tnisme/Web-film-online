
<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>BTN Movie</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="One Movies Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="view/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="view/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="view/css/medile.css" rel='stylesheet' type='text/css' />
<link href="view/css/single.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="view/css/contactstyle.css" type="text/css" media="all" />
<link rel="stylesheet" href="view/css/faqstyle.css" type="text/css" media="all" />
<!-- font-awesome icons -->
<link rel="stylesheet" href="view/css/font-awesome.min.css" />
<!-- //font-awesome icons -->
<!-- news-css -->
<link rel="stylesheet" href="view/news-css/news.css" type="text/css" media="all" />
<!-- //news-css -->
<!-- list-css -->
<link rel="stylesheet" href="view/list-css/list.css" type="text/css" media="all" />
<!-- //list-css -->
<!-- js -->
<script type="text/javascript" src="view/js/jquery-2.1.4.min.js"></script>
<!-- //js -->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300' rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="view/js/move-top.js"></script>
<script type="text/javascript" src="view/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<link href="view/css/owl.carousel.css" rel="stylesheet" type="text/css" media="all">
<script src="view/js/owl.carousel.js"></script>
<script>
	$(document).ready(function() { 
		$("#owl-demo").owlCarousel({
	 
		  autoPlay: 3000, //Set AutoPlay to 3 seconds
	 
		  items : 5,
		  itemsDesktop : [640,5],
		  itemsDesktopSmall : [414,4]
	 
		});
	 
	}); 
</script> 
</head>
	
<body>
<!-- header -->
	<div class="header">
		<div class="container">
			<div class="w3layouts_logo">
				<a href="home"><h1>BTN<span>Movies</span></h1></a>
			</div>
			<div class="w3_search">
				<form action="search" method="post">
					<input type="text" name="Search" placeholder="Search" required="">
					<input type="submit" value="Go">
				</form>
			</div>
			<div class="w3l_sign_in_register">
				<ul>
					<li><i ></i> ${userfullname }</li>
					<li><a href="#" data-toggle="modal" data-target="#myModal">Login</a></li>
					<li>
					<form action="logout" method="post">
					<button formaction="logout" style="padding:0;background-color:orange;height:35px;width:90px;border:none"><p style="color:white;">LOGOUT</p></button>
					</form>
					</li>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //header -->
<!-- bootstrap-pop-up -->
	<div class="modal video-modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					Sign In & Sign Up
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
				</div>
				<section>
					<div class="modal-body">
						<div class="w3_login_module">
							<div class="module form-module">
							  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
								<div class="tooltip">Click Me</div>
							  </div>
							  <div class="form">
								<h3>Login to your account</h3>
								<form action="login" method="post">
								  <input type="text" name="Username" placeholder="Username" required="">
								  <input type="password" name="Password" placeholder="Password" required="">
								  <input type="submit" value="Login">
								</form>
							  </div>
							  <div class="form">
								<h3>Create an account</h3>
								<form action="register" method="post">
								  <input type="text" name="Username" placeholder="Username" required="">
								  <input type="password" name="Password" placeholder="Password" required="">
								  <input type="email" name="Email" placeholder="Email Address" required="">
								  
								  <input  type="submit" value="Register">
								  
								</form>
							  </div>
							  <div class="cta"><a href="#">Forgot your password?</a></div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
	<script>
		$('.toggle').click(function(){
		  // Switches the Icon
		  $(this).children('i').toggleClass('fa-pencil');
		  // Switches the forms  
		  $('.form').animate({
			height: "toggle",
			'padding-top': 'toggle',
			'padding-bottom': 'toggle',
			opacity: "toggle"
		  }, "slow");
		});
	</script>
<!-- //bootstrap-pop-up -->
<!-- nav -->
	<div class="movies_nav">
		<div class="container">
			<nav class="navbar navbar-default">
				<div class="navbar-header navbar-left">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
					<nav>
						<ul class="nav navbar-nav">
							<li class="w3_home_act"><a href="home">Home</a></li>
							<li class="dropdown active">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Genres <b class="caret"></b></a>
								<ul class="dropdown-menu multi-column columns-3">
									<li>
										<div class="col-sm-4">
											<ul class="multi-column-dropdown">
												<li><a href="Action">Action</a></li>
											<li><a href="Comedy">Comedy</a></li>
											<li><a href="Horror">Horror</a></li>
											<li><a href="Family">Family</a></li>
											</ul>
										</div>
										
										<div class="clearfix"></div>
									</li>
								</ul>
							</li>
							<li><a href="series">tv - series</a></li>
							
							
							
							<li><a href="list">A - z list</a></li>
							<li><a href="favorite">Favorite</a></li>
						</ul>
					</nav>
				</div>
			</nav>	
		</div>
	</div>
<!-- //nav -->
<div class="general_social_icons">
	<nav class="social">
		<ul>
			<li class="w3_twitter"><a href="#">Twitter <i class="fa fa-twitter"></i></a></li>
			<li class="w3_facebook"><a href="#">Facebook <i class="fa fa-facebook"></i></a></li>
			<li class="w3_dribbble"><a href="#">Dribbble <i class="fa fa-dribbble"></i></a></li>
			<li class="w3_g_plus"><a href="#">Google+ <i class="fa fa-google-plus"></i></a></li>				  
		</ul>
  </nav>
</div>
<!-- /w3l-medile-movies-grids -->
	<div class="general-agileits-w3l">
		<div class="w3l-medile-movies-grids">

				<!-- /movie-browse-agile -->
				
				      <div class="movie-browse-agile">
					     <!--/browse-agile-w3ls -->
						<div class="browse-agile-w3ls general-w3ls">
								<div class="tittle-head">
									<h4 class="latest-text">Family Movies </h4>
									<div class="container">
										<div class="agileits-single-top">
											<ol class="breadcrumb">
											  <li><a href="home">Home</a></li>
											  <li class="active">Family</li>
											</ol>
										</div>
									</div>
								</div>
								     <div class="container">
							<div class="browse-inner">
							
							
							
							<c:forEach var="i" begin="0" end="${indexfamily }">
							   <div class="col-md-2 w3l-movie-gride-agile">
										 <a href="joinsingle" class="hvr-shutter-out-horizontal"><img src="view/images/${listfamily[i].poster }" title="album-name" alt=" " />
									     <div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									  <div class="mid-1">
										<div class="w3l-movie-text">
										<form action="joinsingle" method="post">
								<input name="id" type="hidden" value="${listfamily[i].id}">
									<button style="width:100%; height:20px; padding: 0;border: none;background: none;"><p style="color:orange;text-decoration: none;">View</p></button>
								</form>
											<h6><a >${listfamily[i].title }</a></h6>							
										</div>
										<div class="mid-2">
										
											<p>${listfamily[i].year }</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													     ${listfamily[i].view } Views
										
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
											
									</div>
							 	    <div class="ribben two">
										<p>NEW</p>
									</div>	
									</div>
									</c:forEach>
									
									
								  

								<div class="clearfix"> </div>
								</div>
								</div>
						</div>
				<!--//browse-agile-w3ls -->
						
					
				    <!-- //movie-browse-agile -->
				   <!--body wrapper start-->
				<!--body wrapper start-->
					<div class="review-slider">
						 <h4 class="latest-text">Movie Reviews</h4>
						       <div class="container">
						 		<div class="w3_agile_banner_bottom_grid">
				<div id="owl-demo" class="owl-carousel owl-theme">
				
				<c:forEach var="i" begin="0" end="6">
					<div class="item">
						<div class="w3l-movie-gride-agile w3l-movie-gride-agile1">
							<a href="joinsingle" class="hvr-shutter-out-horizontal"><img src="view/images/${listreview[i].poster}" title="album-name" class="img-responsive" alt=" " />
								<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
							</a>
							<div class="mid-1 agileits_w3layouts_mid_1_home">
								<div class="w3l-movie-text">
								<form action="joinsingle" method="post">
								<input name="id" type="hidden" value="${listreview[i].id}">
									<button style="width:100%; height:20px; padding: 0;border: none;background: none;"><p style="color:orange;text-decoration: none;">View</p></button>
								</form>
									<h6><a >${listreview[i].title}</a></h6>							
								</div>
								<div class="mid-2 agile_mid_2_home">
									<p>${listreview[i].year}</p>
									<div class="block-stars">
										<ul class="w3l-ratings">
											${listreview[i].view} Views
										</ul>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							<div class="ribben">
								<p>NEW</p>
							</div>
						</div>
					</div>
					
					</c:forEach>
					
					
				</div>
			</div>
						<!--body wrapper end-->
					</div>	
			</div>	
		</div>
	<!-- //w3l-medile-movies-grids -->
	</div>
	<!-- //comedy-w3l-agileits -->
<!-- footer -->
	<div class="footer">
		<div class="container">
			<a style="color:white">ASM JAVA4 BUI TRONG NGHIA</a>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script src="view/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
            $(this).toggleClass('open');       
        }
    );
});
</script>
<!-- //Bootstrap Core JavaScript -->
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
</body>
</html>