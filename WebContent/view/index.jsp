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
<link rel="stylesheet" href="view/css/contactstyle.css" type="text/css" media="all" />
<link rel="stylesheet" href="view/css/faqstyle.css" type="text/css" media="all" />
<link href="view/css/single.css" rel='stylesheet' type='text/css' />
<link href="view/css/medile.css" rel='stylesheet' type='text/css' />
<!-- banner-slider -->
<link href="view/css/jquery.slidey.min.css" rel="stylesheet">
<!-- //banner-slider -->
<!-- pop-up -->
<link href="view/css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
<!-- //pop-up -->
<!-- font-awesome icons -->
<link rel="stylesheet" href="view/css/font-awesome.min.css" />
<!-- //font-awesome icons -->
<!-- js -->
<script type="text/javascript" src="view/js/jquery-2.1.4.min.js"></script>
<!-- //js -->
<!-- banner-bottom-plugin -->
<link href="view/css/owl.carousel.css" rel="stylesheet" type="text/css" media="all">
<script src="view/js/owl.carousel.js"></script>
<script>
	$(document).ready(function() { 
		$("#owl-demo").owlCarousel({
	 
		  autoPlay: 3000, //Set AutoPlay to 3 seconds
	 
		  items : 5,
		  itemsDesktop : [640,4],
		  itemsDesktopSmall : [414,3]
	 
		});
	 
	}); 
</script> 
<!-- //banner-bottom-plugin -->
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
				<div class="collapse navbar-collapse navbar-center" id="bs-example-navbar-collapse-1">
					<nav>
						<ul class="nav navbar-nav">
							<li class="active"><a href="home">Home</a></li>
							<li class="dropdown">
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
<!-- banner -->
	<div id="slidey" style="display:none;">
		<ul>
			
			<li><img src="view/images/banner1.jpg" alt=" " ><p class='title'>Tarzan</p><p class='description'> Câu chuyện xảy ra nhiều năm kể từ khi người đàn ông từng được biết đến như Tarzan rời khu rừng ở châu Phi, bước vào cuộc sống của một quý tộc với tên gọi John Clayton III, Lãnh chúa Greystoke. Cùng với người vợ yêu quý Jane luôn túc trực bên anh</p></li>
			<li><img src="view/images/banner2.jpg" alt=" " ><p class='title'>Maximum Ride</p><p class='description'> Trong phim sáu bạn trẻ phải chiến đâu với những dị nhân khác để trốn chạy khỏi một phòng thí nghiệm đang giam giữ họ và sau khi thoát khỏi phòng thí nghiệm ấy sáu người bạn đã dùng đôi cánh của mình phiêu lưu khắp nơi để tìm ra nguồn gốc của bản thân.</p></li>
			<li><img src="view/images/banner3.jpg" alt=" " ><p class='title'>Independence Day</p><p class='description'> Người ngoài hành tinh đã đến trái đất và mục tiêu của họ là để chiếm lấy tài nguyên và phá huỷ. Chiến đấu bằng công nghệ cao, sử dụng vũ khí tốt nhất của con người là cách duy nhất để tồn tại. Vũ khí hạt nhân đã được sử dụng...</p></li>
			<li><img src="view/images/banner4.jpg" alt=" " ><p class='title'>Central intelligent</p><p class='description'> Phim Central Intelligence 2016 chuyện xoay quanh Bob - một mật vụ CIA (Dwayne Johnson thủ vai) có võ nghệ cao cường, luôn là mối hiểm nguy với bất cứ tên tội phạm nào dù thời còn đi học, anh từng phải chịu nỗi ác mộng vì vẻ bề ngoài xấu xí và bị bạn bè cùng trường trêu chọc</p></li>
			<li><img src="view/images/banner5.jpg" alt=" " ><p class='title'>Ice Age 4</p><p class='description'> Đây là phần 4 của loạt phim đuộc đánh giá là một trong loạt phim hoạt hình được yêu thích và thành công nhất mọi thời đại. Trong phần này nhóm bạn Manny (voi ma-mút), Diego (hổ răng kiếm) và Sid (lười tiền sử) sẽ đối mặt với những thử thách mới do các lục địa bị trôi dạt sau trận Đại hồng thủy. Bên cạnh đó phim có sự xuất hiện của nhiều nhân vật mới như: Squint, Captain Gutt, Flynn</p></li>
			
		</ul>   	
    </div>
    <script src="view/js/jquery.slidey.js"></script>
    <script src="view/js/jquery.dotdotdot.min.js"></script>
	   <script type="text/javascript">
			$("#slidey").slidey({
				interval: 8000,
				listCount: 5,
				autoplay: false,
				showList: true
			});
			$(".slidey-list-description").dotdotdot();
		</script>
<!-- //banner -->
<!-- banner-bottom -->
	<div class="banner-bottom">
		<div class="container">
			<div class="w3_agile_banner_bottom_grid">
				<div id="owl-demo" class="owl-carousel owl-theme">
				<c:forEach var="i" begin="0" end="6">
					<div class="item">
						<div class="w3l-movie-gride-agile w3l-movie-gride-agile1">
							
							<a   class="hvr-shutter-out-horizontal"><img src="view/images/${listreview[i].poster}" title="album-name" class="img-responsive" alt=" " />
							
							
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
										${listreview[i].view} views
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
		</div>
	</div>
<!-- //banner-bottom -->
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
<!-- general -->
	<div class="general">
		<h4 class="latest-text w3_latest_text">Featured Movies</h4>
		<div class="container">
			<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
				<ul id="myTab" class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">Featured</a></li>
					<li role="presentation"><a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile" aria-expanded="false">Top viewed</a></li>
					
					<li role="presentation"><a href="#imdb" role="tab" id="imdb-tab" data-toggle="tab" aria-controls="imdb" aria-expanded="false">Recently Added</a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">
						<div class="w3_agile_featured_movies">
						
						
						
							<c:forEach var="i" begin="0" end="11">
							<div class="col-md-2 w3l-movie-gride-agile">
								<a  class="hvr-shutter-out-horizontal"><img src="view/images/${listfeatured[i].poster}" title="album-name" class="img-responsive" alt=" " />
									<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
								</a>
								<div class="mid-1 agileits_w3layouts_mid_1_home">
									<div class="w3l-movie-text">
									<form action="joinsingle" method="post">
									<input name="id" type="hidden" value="${listfeatured[i].id}">
									<button style="width:100%; height:20px; padding: 0;border: none;background: none;"><p style="color:orange;text-decoration: none;">View</p></button>
								</form>
										<h6><a >${listfeatured[i].title}</a></h6>							
									</div>
									<div class="mid-2 agile_mid_2_home">
										<p>${listfeatured[i].year}</p>
										<div class="block-stars">
											<ul class="w3l-ratings">
												${listfeatured[i].view} views
											</ul>
										</div>
										<div class="clearfix"></div>
									</div>
								</div>
								<div class="ribben">
									<p>NEW</p>
								</div>
							</div>
							</c:forEach>
							
							
							
							<div class="clearfix"> </div>
						</div>
					</div>
					<!-- cách nhau 2 trang bằng đoạn code dưới -->
					<div role="tabpanel" class="tab-pane fade" id="profile" aria-labelledby="profile-tab">
						
						
						<c:forEach var="i" begin="0" end="11">
						<div class="col-md-2 w3l-movie-gride-agile">
							<a  class="hvr-shutter-out-horizontal"><img src="view/images/${listtopviews[i].poster}" title="album-name" class="img-responsive" alt=" " />
								<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
							</a>
							<div class="mid-1 agileits_w3layouts_mid_1_home">
								<div class="w3l-movie-text">
								<form action="joinsingle" method="post">
								<input name="id" type="hidden" value="${listtopviews[i].id}">
									<button style="width:100%; height:20px; padding: 0;border: none;background: none;"><p style="color:orange;text-decoration: none;">View</p></button>
								</form>
									<h6><a >${listtopviews[i].title}</a></h6>							
								</div>
								<div class="mid-2 agile_mid_2_home">
									<p>${listtopviews[i].year}</p>
									<div class="block-stars">
										${listtopviews[i].view} views
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							<div class="ribben">
								<p>NEW</p>
							</div>
						</div>
						</c:forEach>
						
						
	
						<div class="clearfix"> </div>
					</div>
					<div role="tabpanel" class="tab-pane fade" id="imdb" aria-labelledby="imdb-tab">
						
						
						
						
						<c:forEach var="i" begin="0" end="11">
						<div class="col-md-2 w3l-movie-gride-agile">
							<a  class="hvr-shutter-out-horizontal"><img src="view/images/${listrecently[i].poster}" title="album-name" class="img-responsive" alt=" " />
								<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
							</a>
							<div class="mid-1 agileits_w3layouts_mid_1_home">
								<div class="w3l-movie-text">
								<form action="joinsingle" method="post">
								<input name="id" type="hidden" value="${listrecently[i].id}">
									<button style="width:100%; height:20px; padding: 0;border: none;background: none;"><p style="color:orange;text-decoration: none;">View</p></button>
								</form>
									<h6><a >${listrecently[i].title}</a></h6>							
								</div>
								<div class="mid-2 agile_mid_2_home">
									<p>${listrecently[i].year}</p>
									<div class="block-stars">
										${listrecently[i].view} views
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							<div class="ribben">
								<p>NEW</p>
							</div>
						</div>
						</c:forEach>
						

						
						<div class="clearfix"> </div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- //general -->
<!-- Latest-tv-series -->
	<div class="Latest-tv-series">
		<h4 class="latest-text w3_latest_text w3_home_popular">Most Popular Movies</h4>
		<div class="container">
			<section class="slider">
				<div class="flexslider">
					<ul class="slides">
					
					
						
						<li>
							<div class="agile_tv_series_grid">
								<div class="col-md-6 agile_tv_series_grid_left">
									<div class="w3ls_market_video_grid1">
										<img src="view/images/h1-1.jpg" alt=" " class="img-responsive" />
										<a class="w3_play_icon" href="#small-dialog">
											<span class="glyphicon glyphicon-play-circle" aria-hidden="true"></span>
										</a>
									</div>
								</div>
								<div class="col-md-6 agile_tv_series_grid_right">
									<p class="fexi_header">${listslidebanner[1].title}</p>
									<p class="fexi_header_para"><span class="conjuring_w3">Story Line<label>:</label></span> ${listslidebanner[1].description} </p>
									<p class="fexi_header_para"><span>Year of Release<label>:</label></span>  ${listslidebanner[1].year} </p>
									<p class="fexi_header_para">
										<span>Genres<label>:</label> </span>
										<a href="view/genres.jsp">${listslidebanner[1].genre}</a> 
																	
									</p>
									<p class="fexi_header_para fexi_header_para1"><span>Views<label>:</label></span>
										${listslidebanner[1].view} 
									</p>
								</div>
								<div class="clearfix"> </div>
								<div class="agileinfo_flexislider_grids">
								<c:forEach var="i" begin="0" end="5">
									<div class="col-md-2 w3l-movie-gride-agile">
										<a  class="hvr-shutter-out-horizontal"><img src="view/images/${listslideview[i].poster}" title="album-name" class="img-responsive" alt=" " />
											<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
										</a>
										<div class="mid-1 agileits_w3layouts_mid_1_home">
											<div class="w3l-movie-text">
											<form action="joinsingle" method="post">
											<input name="id" type="hidden" value="${listslideview[i].id}">
									<button style="width:100%; height:20px; padding: 0;border: none;background: none;"><p style="color:orange;text-decoration: none;">View</p></button>
								</form>
												<h6><a >${listslideview[i].title}</a></h6>							
											</div>
											<div class="mid-2 agile_mid_2_home">
												<p>${listslideview[i].year}</p>
												<div class="block-stars">
													<ul class="w3l-ratings">
														${listslideview[i].view} Views
													</ul>
												</div>
												<div class="clearfix"></div>
											</div>
										</div>
										<div class="ribben">
											<p>NEW</p>
										</div>
									</div>
									</c:forEach>
									
									<div class="clearfix"> </div>
								</div>
							</div>
						</li>
						
						
						
						<li>
							<div class="agile_tv_series_grid">
								<div class="col-md-6 agile_tv_series_grid_left">
									<div class="w3ls_market_video_grid1">
										<img src="view/images/h2-1.jpg" alt=" " class="img-responsive" />
										<a class="w3_play_icon" href="#small-dialog">
											<span class="glyphicon glyphicon-play-circle" aria-hidden="true"></span>
										</a>
									</div>
								</div>
								<div class="col-md-6 agile_tv_series_grid_right">
									<p class="fexi_header">${listslidebanner[0].title}</p>
									<p class="fexi_header_para"><span class="conjuring_w3">Story Line<label>:</label></span> ${listslidebanner[0].description}</p>
									<p class="fexi_header_para"><span>Year of Release<label>:</label></span>  ${listslidebanner[0].year} </p>
									<p class="fexi_header_para">
										<span>Genres<label>:</label> </span>
										<a href="view/genres.jsp">${listslidebanner[0].genre}</a> 
																	
									</p>
									<p class="fexi_header_para fexi_header_para1"><span>Views<label>:</label></span>
										${listslidebanner[0].view} 
									</p>
								</div>
								<div class="clearfix"> </div>
								<div class="agileinfo_flexislider_grids">
								<c:forEach var="i" begin="6" end="11">
									<div class="col-md-2 w3l-movie-gride-agile">
										<a  class="hvr-shutter-out-horizontal"><img src="view/images/${listslideview[i].poster}" title="album-name" class="img-responsive" alt=" " />
											<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
										</a>
										<div class="mid-1 agileits_w3layouts_mid_1_home">
											<div class="w3l-movie-text">
											<form action="joinsingle" method="post">
											<input name="id" type="hidden" value="${listslideview[i].id}">
									<button style="width:100%; height:20px; padding: 0;border: none;background: none;"><p style="color:orange;text-decoration: none;">View</p></button>
								</form>
												<h6><a >${listslideview[i].title}</a></h6>							
											</div>
											<div class="mid-2 agile_mid_2_home">
												<p>${listslideview[i].year}</p>
												<div class="block-stars">
													<ul class="w3l-ratings">
														${listslideview[i].view} Views
													</ul>
												</div>
												<div class="clearfix"></div>
											</div>
										</div>
										<div class="ribben">
											<p>NEW</p>
										</div>
									</div>
									</c:forEach>
									
									<div class="clearfix"> </div>
								</div>
							</div>
						</li>
						
						
						
						<li>
							<div class="agile_tv_series_grid">
								<div class="col-md-6 agile_tv_series_grid_left">
									<div class="w3ls_market_video_grid1">
										<img src="view/images/h3-1.jpg" alt=" " class="img-responsive" />
										<a class="w3_play_icon" href="#small-dialog">
											<span class="glyphicon glyphicon-play-circle" aria-hidden="true"></span>
										</a>
									</div>
								</div>
								<div class="col-md-6 agile_tv_series_grid_right">
									<p class="fexi_header">${listslidebanner[2].title}</p>
									<p class="fexi_header_para"><span class="conjuring_w3">Story Line<label>:</label></span> ${listslidebanner[2].description}</p>
									<p class="fexi_header_para"><span>Year of Release<label>:</label></span>  ${listslidebanner[2].year} </p>
									<p class="fexi_header_para">
										<span>Genres<label>:</label> </span>
										<a href="view/genres.jsp">${listslidebanner[2].genre}</a> 
																	
									</p>
									<p class="fexi_header_para fexi_header_para1"><span>Views<label>:</label></span>
										${listslidebanner[2].view} 
									</p>
								</div>
								<div class="clearfix"> </div>
								<div class="agileinfo_flexislider_grids">
								<c:forEach var="i" begin="11" end="16">
									<div class="col-md-2 w3l-movie-gride-agile">
										<a  class="hvr-shutter-out-horizontal"><img src="view/images/${listslideview[i].poster}" title="album-name" class="img-responsive" alt=" " />
											<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
										</a>
										<div class="mid-1 agileits_w3layouts_mid_1_home">
											<div class="w3l-movie-text">
											<form action="joinsingle" method="post">
											<input name="id" type="hidden" value="${listslideview[i].id}">
									<button style="width:100%; height:20px; padding: 0;border: none;background: none;"><p style="color:orange;text-decoration: none;">View</p></button>
								</form>
												<h6><a >${listslideview[i].title}</a></h6>							
											</div>
											<div class="mid-2 agile_mid_2_home">
												<p>${listslideview[i].year}</p>
												<div class="block-stars">
													<ul class="w3l-ratings">
														${listslideview[i].view} Views
													</ul>
												</div>
												<div class="clearfix"></div>
											</div>
										</div>
										<div class="ribben">
											<p>NEW</p>
										</div>
									</div>
									</c:forEach>
									
									<div class="clearfix"> </div>
								</div>
							</div>
						</li>
						
						

					</ul>
				</div>
			</section>
			<!-- flexSlider -->
				<link rel="stylesheet" href="view/css/flexslider.css" type="text/css" media="screen" property="" />
				<script defer src="view/js/jquery.flexslider.js"></script>
				<script type="text/javascript">
				$(window).load(function(){
				  $('.flexslider').flexslider({
					animation: "slide",
					start: function(slider){
					  $('body').removeClass('loading');
					}
				  });
				});
			  </script>
			<!-- //flexSlider -->
		</div>
	</div>
	<!-- pop-up-box -->  
		<script src="view/js/jquery.magnific-popup.js" type="text/javascript"></script>
	<!--//pop-up-box -->
	<div id="small-dialog" class="mfp-hide">
		<iframe src="https://player.vimeo.com/video/164819130?title=0&byline=0"></iframe>
	</div>
	<div id="small-dialog1" class="mfp-hide">
		<iframe src="https://player.vimeo.com/video/148284736"></iframe>
	</div>
	<div id="small-dialog2" class="mfp-hide">
		<iframe src="https://player.vimeo.com/video/165197924?color=ffffff&title=0&byline=0&portrait=0"></iframe>
	</div>
	<script>
		$(document).ready(function() {
		$('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
			type: 'inline',
			fixedContentPos: false,
			fixedBgPos: true,
			overflowY: 'auto',
			closeBtnInside: true,
			preloader: false,
			midClick: true,
			removalDelay: 300,
			mainClass: 'my-mfp-zoom-in'
		});
																		
		});
	</script>
<!-- //Latest-tv-series -->
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