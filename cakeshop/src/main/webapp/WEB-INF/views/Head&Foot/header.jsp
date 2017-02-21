<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

</head>
<body>
	<header class="main_menu_sec navbar navbar-inverse ">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-12">
					<div class="lft_hd">
						<a href="index"><img src="resources/img/logo.jpg" alt="" /></a>
					</div>
				</div>
				<div class="col-lg-9 col-md-9 col-sm-12">
					<div class="rgt_hd">
						<div class="main_menu">
							<nav id="nav_menu">
								<div id="navbar">
									<ul>
										<c:if test="${pageContext.request.userPrincipal.name == null}">
										<li><a class="page-scroll" href="index">Home</a></li>
										<li><a href="#">Shop </a>
											<ul id="selectedCategory">
												<c:forEach items="${categoryList}" var="category">
													<li><a href="userShop/${category.name}">${category.name}</a></li>
												</c:forEach>
											</ul></li>
										<li><a href="MyCart">Cart(${cartSize})</a></li>
											<li><a href="register">Signup</a></li>

											<li><a class="btn btn-outline btn-circle collapsed"
												href="login" aria-expanded="false"
												aria-controls="nav-collapse2">Log In</a></li>
										</c:if>
										<c:if test="${pageContext.request.userPrincipal.name != null}">
											<%-- <c:if test="${not empty loggedInUser}">Welcome ${loggedInUser} --%>
																					<li><a class="page-scroll" href="index">Home</a></li>
											
											<li><a href="#">News</a></li>
<%-- 											<c:if test="${isAdmin == false }"> --%>	
						<sec:authorize access="hasRole('ROLE_USER')">

<%-- 					<c:if test="${user.role == 'ROLE_USER'}">
 --%>											<li><a href="MyCart">Cart(${cartSize})</a></li>
												<li><a href="#">Shop </a>
													<ul id="selectedCategory">
														<c:forEach items="${categoryList}" var="category">
															<li><a href="userShop/${category.name}">${category.name}</a></li>
														</c:forEach>
													</ul></li>
<%-- 											</c:if>
 --%>											</sec:authorize>
						<%-- 	${(User)pageContext.request.userPrincipal} 
							    ${pageContext.request.userPrincipal}  --%>	       
						<sec:authorize access="hasRole('ROLE_ADMIN')">
											
<%-- 					<c:if test="${user.role=='ROLE_ADMIN'}">
 --%>					
												<li><a href="#">Manage</a>
													<ul>
														<li><a href="Supplier">Manage Suppliers</a></li>
														<li><a href="Product">Manage Products</a></li>
														<li><a href="Category">Manage Category</a></li>
													</ul></li>
<%-- 											</c:if>
 --%></sec:authorize>
											<li><a href="logOut">LogOut</a></li>
											<%-- </c:if> --%>
											<c:url value="/logOut" var=" logoutUrl" />
											<form action="${logoutUrl}" method="POST" id="logoutForm">
												<input type="hidden" name="${_csrf.parameterName}"
													value="${_csrf.token}" />
											</form>
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
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</div>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
</body>
</html>