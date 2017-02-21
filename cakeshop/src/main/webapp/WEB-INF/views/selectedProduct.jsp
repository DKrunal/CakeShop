<!DOCTYPE html>
<html lang="en">
<head>
<title>PRODUCT</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/product.css">
</head>
<body>
	<div class="container-fluid">
		<div class="content-wrapper">
			<div class="item-container">
				<div class="container">
					<div class="col-md-12">
						<div class="product col-md-3 service-image-left">
							<img id="item-display" src="<c:url value="resources/img/${product.product_id}.jpg"/>" alt="${product.product_id}"></img>
						</div>
						<div class="col-md-7">
							<div class="product-title">
								<u><c:out value="${product.name}" /></u>
							</div>
							<div class="product-rating">
								<i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i>
								<i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i>
								<i class="fa fa-star-o"></i>
							</div>
							<hr>
							<div class="product-price">Rs: ${product.price}/-</div>
							<div class="product-stock">In Stock</div>
							<hr>
							<c:choose>
								<c:when test="${product.stock == 0}">
									<button class="btn btn-danger btn-lg disabled">Out Of
										Stock</button>
								</c:when>
								<c:otherwise>
								
								</c:otherwise>
							</c:choose>
							<div class="btn-group cart">
									<a class="btn btn-success btn-block"
										href="<c:url value='MyCart_add-${product.product_id}' />">Add
										to Cart</a>
							</div>
							<div class="btn-group wishlist">
								<a class="btn btn-warning btn-block"
										href="<c:url value='buy_now-${product.product_id}' />">Buy
										Now</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid">
				<div class="col-md-12 product-info">
					<ul id="myTab" class="nav nav-tabs nav_tabs">

						<li class="active"><a href="#service-one" data-toggle="tab">DESCRIPTION</a></li>


					</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade in active" id="service-one">

							<section class="container product-info">

								<h3>${product.name}</h3>
								<li>${product.description}</li>
							</section>
						</div>
					</div>
					<hr>
				</div>
			</div>
		</div>
	</div>
</body>
</html>