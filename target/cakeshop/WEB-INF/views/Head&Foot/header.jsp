<!doctype html>
<html class="" lang="">
<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=-1">
<title>header</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/style.css">
</head>

<nav class="navbar navbar-inverse">
	<div class="col-lg-3 col-md-3 col-sm-12">
		<div class="lft_hd">
			<a href="index"><img src="resources/img/logo.jpg" alt="" /></a>
		</div>
		<div class="container">

			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">

				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar-collapse-2">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbar-collapse-2">
				<div class="rgt_hd">
					<ul class="nav navbar-nav navbar-right">

<c:if test="${empty loggedInUser}">

							<li><a href="register">Signup</a></li>
							<li><a
								class="btn btn-default btn-outline btn-circle collapsed"
								data-toggle="collapse" href="#nav-collapse2"
								aria-expanded="false" aria-controls="nav-collapse2">Log In</a></li>
						</c:if>
						
						
						<c:if test="${not empty loggedInUser}">
						Welcome ${loggedInUser}
							<li><a href="index">Home</a></li>
							<li><a href="#">Shop</a></li>
							<li><a href="#">News</a></li>
							<c:if test="${isAdmin == false }">
								<li><a href="#">Cart</a></li>
							</c:if>
								<c:if test="${isAdmin == true }">
							<ul class="nav navbar-nav collapse navbar-collapse">
							<li class="dropdown"><a href="#">Manage<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                       <li><a href="Supplier">Manage Suppliers</a></li>
								<li><a href="Product">Manage Products</a></li>
								<li><a href="Category">Manage Category</a></li>
                                    </ul>
                                </li> 
                                </ul>
							</c:if>
							<li>
							<li><a href="logOut">LogOut</a></li>
								</c:if>
								
					</ul>
					<div class="collapse nav navbar-nav nav-collapse slide-down"
						id="nav-collapse2">
						<form class="navbar-form navbar-right form-inline" role="form"
							method="post" action="validate">
							<div class="form-group">
								<label class="sr-only" for="UserName">UserName</label> <input
									type="text" class="form-control" placeholder="username"
									name="id" autofocus required />
							</div>
							<div class="form-group">
								<label class="sr-only" for="Password">Password</label> <input
									type="password" class="form-control" placeholder="Password"
									name="password" required />
							</div>
							<button type="submit" class="btn btn-success">Log In</button>
						</form>
					</div>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.rgt_hd -->

		</div>
		<!-- /.container -->
	</div>
</nav>
<!-- /.navbar -->