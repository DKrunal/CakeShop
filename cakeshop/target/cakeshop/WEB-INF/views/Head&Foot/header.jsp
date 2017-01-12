<!doctype html>
<html class="" lang="">
<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=-1">
<title>header</title>
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
			<a href="index.jsp"><img src="resources/img/logo.jpg" alt="" /></a>
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

						<li><a href="index">Home</a></li>
						<li><a href="#">Services</a></li>
						<li><a href="#">Works</a></li>
						<li><a href="#">News</a></li>
						<li><a href="signup">Signup</a></li>


						<li><a
							class="btn btn-default btn-outline btn-circle collapsed"
							data-toggle="collapse" href="#nav-collapse2"
							aria-expanded="false" aria-controls="nav-collapse2">Log In</a></li>


					</ul>
					<div class="collapse nav navbar-nav nav-collapse slide-down"
						id="nav-collapse2">
						<form class="navbar-form navbar-right form-inline" role="form" method="post" action="validate">
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