<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>checkout</title>
</head>
<body>
		<div class="content">
			<div class="panel panel-primary">
				<div class="panel-heading">Shipping Address</div>
				<div class="panel-body">
				<div class="col-md-4 col-md-offset-4">
					<form:form class="form-horizontal" commandName="shippingAddress">
						<div class="form-group">
							<label for="" class="control-label col-sm-2">Line 1</label>
							<div class="col-sm-10">
								<form:errors path="line1" class="error" />
								<form:input path="line1" type="text" autofocus="true" class="form-control" required="true"/>
							</div>
						</div>
						<div class="form-group">
							<label for="" class="control-label col-sm-2">Line 2</label>
							<div class="col-sm-10">
								<form:errors path="line2" class="error" />
								<form:input path="line2" type="text" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="" class="control-label col-sm-2">City</label>
							<div class="col-sm-10">
								<form:errors path="city" class="error" />
								<form:input path="city" type="text"  class="form-control" required="true"/>
							</div>
						</div>
						<div class="form-group">
							<label for="" class="control-label col-sm-2">State</label>
							<div class="col-sm-10">
								<form:errors path="state" class="error" />
								<form:input type="text" path="state" class="form-control" required="true"/>
							</div>
						</div>
						<div class="form-group">
							<label for="" class="control-label col-sm-2">Country</label>
							<div class="col-sm-10">
								<form:errors path="country" class="error" />
								<form:input type="text" path="country" class="form-control" required="true"/>
							</div>
						</div>
						<div class="form-group">
							<label for="" class="control-label col-sm-2">Zip code</label>
							<div class="col-sm-10">
								<form:errors path="zipCode" class="error" />
								<form:input type="text" path="zipCode" pattern="^[1-9][0-9]{5}$" title="Enter a 6 digit pincode" class="form-control" required="true"/>
							</div>
						</div>
						<div class="col-md-offset-3">
							<input type="submit" name="_eventId_submitShippingAddress"
								class="btn btn-md btn-success" value="Save">
								
							<!-- <button type="cancel" name="_eventId_cancel"
								class="btn btn-md btn-danger" value="Cancel">cancel</button> -->
								
								 <a href="cancelEvent" type="button" name="_eventId_cancel" class="btn btn-md btn-danger">
					 cancel </a>
						</div>
					</form:form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>