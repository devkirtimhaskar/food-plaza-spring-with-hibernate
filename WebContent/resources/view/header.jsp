<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FoodPlaza.COM</title>

	<link rel="icon" type="image/*" href="resources/images/foodplaza.png"/>
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css" >
	<script src="resources/js/jquery-3.3.1.slim.min.js"></script>
	<script src="resources/js/popper.min.js" ></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("li.nav-item").click(function(){
				 $('li.nav-item').removeClass('active'); 
				 $(this).addClass('active'); 
			});
		})
	</script>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
	  <div class="container">
	    <a class="navbar-brand" href="#">
	    <img src="resources/images/foodplaza.png" height="100px" class="d-inline-block align-top" alt=""></a>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarResponsive">
	      <ul class="navbar-nav ml-auto">
	        <li class="nav-item active">
	          <a class="nav-link" id="home" href="home">Home
	                <span class="sr-only">(current)</span>
	              </a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#">About</a>
	        </li>
	        <core:if test="${admin!=null and customer==null}">
	        <li class="nav-item">
	          <a class="nav-link" id="addfood" href="addfood">Add Food</a>
	        </li>
	        
	        <li class="nav-item">
	          <a class="nav-link" id="foodlist" href="foodlist">Food List</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" id="custlist" href="custlist">Customer List</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" id="showallcart" href="showallcart">All Cart's</a>
	        </li>
	        </core:if>
	        <core:if test="${admin==null and customer==null}">
	        <li class="nav-item">
	          <a class="nav-link" id="addcustomer" href="addcustomer">Register</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" id="login" href="loginform">Login</a>
	        </li>
	        </core:if>
	        <core:if test="${admin==null and customer!=null}">
	        <li class="nav-item">
	          <a class="nav-link" id="showmycart" href="showmycart">Cart</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" id="myprofile" href="myprofile">My Profile</a>
	        </li>
	        </core:if>
	        <core:if test="${admin!=null or customer!=null}">
	        <li class="nav-item">
	          <a class="nav-link" id="logout" href="logout">Logout</a>
	        </li>
	        </core:if>
	        <li class="nav-item">
	          <a class="nav-link" href="#">Contact</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
	<header>
	  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
	    <ol class="carousel-indicators">
	      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
	      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	    </ol>
	    <div class="carousel-inner" role="listbox">
	      <!-- Slide One - Set the background image for this slide in the line below -->
	      <div class="carousel-item active" style="background-image: url('resources/images/slides/slide1.jpg');">
	        <div class="carousel-caption d-none d-md-block">
	          
	        </div>
	      </div>
	      <!-- Slide Two - Set the background image for this slide in the line below -->
	      <div class="carousel-item" style="background-image: url('resources/images/slides/slide2.jpg')">
	        <div class="carousel-caption d-none d-md-block">
	        </div>
	      </div>
	      <!-- Slide Three - Set the background image for this slide in the line below -->
	      <div class="carousel-item" style="background-image: url('resources/images/slides/slide3.jpg')">
	        <div class="carousel-caption d-none d-md-block">

	        </div>
	      </div>
	    </div>
	    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
	          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	          <span class="sr-only">Previous</span>
	        </a>
	    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
	          <span class="carousel-control-next-icon" aria-hidden="true"></span>
	          <span class="sr-only">Next</span>
	        </a>
	  </div>
	</header>
	
	</body>
	</html>
	