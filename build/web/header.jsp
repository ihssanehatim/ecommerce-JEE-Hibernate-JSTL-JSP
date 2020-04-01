<%@page import="mini.projet.BO.Products"%>
<%@page import="mini.projet.BO.Categories"%>
<%@page import="java.util.List"%>
<%@page import="mini.projet.DAO.ProductsMetier"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>ElectroIHSSANE</title>

		<!-- Google font -->
		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

		<!-- Bootstrap -->
		<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

		<!-- Slick -->
		<link type="text/css" rel="stylesheet" href="css/slick.css"/>
		<link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

		<!-- nouislider -->
		<link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

		<!-- Font Awesome Icon -->
		<link rel="stylesheet" href="css/font-awesome.min.css">

		<!-- Custom stlylesheet -->
		<link type="text/css" rel="stylesheet" href="css/style.css"/>

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

    </head>
	<body>
		<!-- HEADER -->
		<header>
			<!-- TOP HEADER -->
			<div id="top-header">
				<div class="container">
				<!--	<ul class="header-links pull-left">
						<li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
						<li><a href="#"><i class="fa fa-envelope-o"></i> email@email.com</a></li>
						<li><a href="#"><i class="fa fa-map-marker"></i> 1734 Stonecoal Road</a></li>
					</ul>
					-->
					<ul class="header-links pull-right">
						<!--  <li><a href="#"><i class="fa fa-dollar"></i> USD</a></li> -->
						<li><a href="/ecommerce/Authentif"><i class="fa fa-sign-in"></i> My Account</a></li>
					</ul>
                                        
                                        <% if(request.getSession().getAttribute("username")!=null){ %>
                                        
                                      <ul class="header-links pull-left">
						<!--  <li><a href="#"><i class="fa fa-dollar"></i> USD</a></li> -->
						<li><a href="/ecommerce/Authentif?id=0"><i class="fa fa-sign-out"></i> Log Out</a></li>
					</ul>
                                        <% } %>
				</div>
			</div>
			<!-- /TOP HEADER -->

			<!-- MAIN HEADER -->
			<div id="header">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<!-- LOGO -->
						<div class="col-md-3">
							<div class="header-logo">
								<a href="/ecommerce/prod" class="logo">
									<img src="./img/logo.png" alt="">
								</a>
							</div>
						</div>
						<!-- /LOGO -->

						<!-- SEARCH BAR -->
						<div class="col-md-6">
							<div class="header-search">
								<form>
									<!--  <select class="input-select">
										<option value="0">All Categories</option>
										<option value="1">Category 01</option>
										<option value="1">Category 02</option>
									</select>
									-->
									<input class="input" placeholder="Search here">
									<button class="search-btn">Search</button>
								</form>
							</div>
						</div>
						<!-- /SEARCH BAR -->

						<!-- ACCOUNT -->
						<div class="col-md-3 clearfix">
							<div class="header-ctn">
								<!-- Wishlist 
								<div>
									<a href="#">
										<i class="fa fa-heart-o"></i>
										<span>Your Wishlist</span>
										<div class="qty">2</div>
									</a>
								</div>
								<!-- /Wishlist -->

								<!-- Cart -->
                                                                
								<div class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
										<i class="fa fa-shopping-cart"></i>
										<span>Your Cart</span>
                                                                                <div class="qty">
                                                                                    <c:if test = "${sessionScope.nbreOfProd >= 0 && !empty sessionScope.nbreOfProd}">
                                                                                    <c:out value="${sessionScope.nbreOfProd}"/>
                                                                                    </c:if>
                                                                                    <c:if test = "${empty sessionScope.nbreOfProd}">
                                                                                    <c:out value="0"/>
                                                                                    </c:if>
                                                                                </div>
									</a>
									<div class="cart-dropdown">
										<div class="cart-list">
                                                                                     <c:forEach items="${sessionScope.MAP}" var="entry" >
                                                         
											<div class="product-widget">
												<div class="product-img">
													<img src="./img/product01.png" alt="">
												</div>
												<div class="product-body">
													<h3 class="product-name"><a href="#"><c:out value="${entry.key.label}"/></a></h3>
													<h4 class="product-price"><span class="qty"><c:out value="${entry.value}"/>x</span><c:out value="${entry.key.price}"/></h4>
												</div>
                                                                                               
												<button class="delete" name='delete' ><i class="fa fa-close"></i></button>
											</div>
                                                                                            </c:forEach>
											
										</div>
										<div class="cart-summary">
                                                                                    <small> <c:out value="${sessionScope.nbreOfProd}" />Item(s) selected</small>
											<h5>SUBTOTAL:<c:out value="${sessionScope.price}" /> </h5>
										</div>
										<div class="cart-btns">
											<a href="/ecommerce/cart">View Cart</a>
											<a href="/ecommerce/panier">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
										</div>
									</div>
								</div>
								<!-- /Cart -->

								<!-- Menu Toogle -->
								<div class="menu-toggle">
									<a href="#">
										<i class="fa fa-bars"></i>
										<span>Menu</span>
									</a>
								</div>
								<!-- /Menu Toogle -->
							</div>
						</div>
						<!-- /ACCOUNT -->
					</div>
					<!-- row -->
				</div>
				<!-- container -->
			</div>
			<!-- /MAIN HEADER -->
		</header>
		<!-- /HEADER -->

		<!-- NAVIGATION -->
		<nav id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
						<li class="active"><a href="/ecommerce/prod">Home</a></li>
						<li><a href="#">Hot Deals</a></li>
						<li><a href="/ecommerce/prod">Categories</a></li>
						<li><a href="#">Laptops</a></li>
						<li><a href="#">Smartphones</a></li>
						<li><a href="#">Cameras</a></li>
						<li><a href="#">Accessories</a></li>
					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>
		<!-- /NAVIGATION -->