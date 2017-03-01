<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
                <c:forEach items="${cartList}" var="cart">
                <tbody>
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="<c:url value="resources/img/${cart.product_id}.jpg"/>" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${cart.product_name}</a></h4>
                                <h5 class="media-heading"> by <a href="#">${category.name}</a></h5>
                                <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                        <input type="email" class="form-control" id="exampleInputEmail1" value="${cart.quantity}">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>&#8377.${cart.price}/-</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong></strong></td>
                        <td class="col-sm-1 col-md-1">
                        <a href="<c:url value='cart_delete-${cart.cartId}'/>"><button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Remove
                        </button></a></td>
                    </tr>

                </tbody>
                </c:forEach>
                <tfoot>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total &#8377.${sum} </h3></td>
                       
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <a href="index" type="button" class="btn btn-warning btn-block">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </a></td>
                        <td>
                        <a href="PurchaseNow" type="button" class="btn btn-success btn-block">
						<span class="glyphicon glyphicon glyphicon-arrow-right"></span> CHECKOUT </a>
                       </td>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
</body>
</html>