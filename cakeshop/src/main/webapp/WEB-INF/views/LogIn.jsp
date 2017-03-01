<%@ include file="Head&Foot/header.jsp"%>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
  <meta charset="UTF-8">
<style>

</style>
  
</head>

<body>

  <body>
<div class="container">
	<section id="content">
	 <c:url var="loginUrl" value="/j_spring_security_check" />
		<form  action="${loginUrl}" method="post" >
			<h1>Login</h1>
			 
			<div>
				<input type="text" placeholder="Username" required id="id" name="id" class="form-control" required/>
				
			</div>
			<div>
				<input type="password" placeholder="Password" required id="password" class="form-control" name="password"  required />
			</div>
			<div>
				<input type="submit" value="Let me order" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<a href="SignUp.html">Forget Password?</a>
			</div>
		</form><!-- form -->
	</section><!-- content -->
</div><!-- container -->

</body>

</body>
<%@ include file="Head&Foot/footer.jsp"%>

