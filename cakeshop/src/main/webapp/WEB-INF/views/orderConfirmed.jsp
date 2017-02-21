<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<div class="row text-center">
        <div class="col-sm-6 col-sm-offset-3">
        <br><br> <h2 style="color:#0fad00">Your Order Deliver</h2>
        <img src="resources/img/check-true.jpg">
        <h3>Dear, ${pageContext.request.userPrincipal.name}</h3>
        <p style="font-size:20px;color:#5C5C5C;">Thank you for ordering from our site.</p>
        <p style="font-size:20px;color:#5C5C5C;">your order is deliver with in 48Hours</p>
        <a href="backToHome" class="btn btn-success">     Home      </a>
    <br><br>
        </div>
        
	</div>
</div>

	

</body>
</html>