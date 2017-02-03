<!DOCTYPE html>
<html lang="en">
<head>
<title>PRODUCT</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							<img id="item-display" src="1.jpg" alt=""></img>
						</div>
						<div class="col-md-7">
							<div class="product-title"><c:out value="${product.name}"/></div>
							<div class="product-rating">
								<i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i>
								<i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i>
								<i class="fa fa-star-o"></i>
							</div>
							<hr>
							<div class="product-price">${product.price}</div>
							<div class="product-stock">In Stock</div>
							<hr>
							<div class="btn-group cart">
								<button type="button" class="btn btn-success">Add to
									cart</button>
							</div>
							<div class="btn-group wishlist">
								<button type="button" class="btn btn-danger">Add to
									wishlist</button>
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