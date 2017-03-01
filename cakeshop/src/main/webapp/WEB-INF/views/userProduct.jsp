<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="resources/css/category.css">
<title>Product</title>
</head>
<body>
	<c:if test="${!empty productList}">
	
<div class="container" style="margin-top:50px;">
	<div class="row">
	<c:forEach items="${productList}" var="product">
    	<div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="post-img-content">
                    <img src="resources/img/${product.product_id}.jpg" alt="${product.product_id}" class="img-responsive" />
                    <span class="post-title">
                        <b>${category.name}</b><br>
                    </span>
                    <span class="round-tag">0%</span>
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5>${product.name}</h5>
                           
                        </div>
                       <div class="rating hidden-sm col-md-6">
                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="fa fa-star"></i>
                             <h5 class="price-text-color">Rs:${product.price}/-</h5>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="MyCart_add-${product.product_id}" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="selectedProduct/${product.product_id}" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
         </c:forEach>
        </div>
        </div>
       
        </c:if>
</body>
</html>