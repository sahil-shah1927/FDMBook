<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FDMBook - Log in</title>

<link rel="shortcut icon" type="image/png" href="images/favicon.png" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="styles/main.css" />
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<%@ include file="nav.jsp"%>
	<br>
	<div id="login-register" class="center-block">

		<ul class="nav nav-tabs login-register-tab">
			<li><a href="#" class="tablinks login-tab active">Log in</a></li>
			<li><a href="#" class="tablinks register-tab">Register</a></li>
		</ul>

		<div class="tabcontent login-form">


			<form action="LoginUser" method="POST" class="id-form">
				<div class="form-group">
					<div class="input-group width-75">
						<div class="input-group-addon">
							<i class="fa fa-user fa-fw" aria-hidden="true"></i>
						</div>
						<input type="text" class="form-control" name="username"
							autofocus="autofocus" required="required" placeholder="Username"
							maxlength="30">
					</div>

				</div>
				<div class="form-group">
					<div class="input-group width-75">
						<div class="input-group-addon">
							<i class="fa fa-key fa-fw" aria-hidden="true"></i>
						</div>
						<input type="password" class="form-control" name="password"
							autofocus="autofocus" required="required" placeholder="Password"
							maxlength="30">
					</div>

				</div>
				<p class="errorMessage">${LoginError}</p>
				<div>
					<button type="submit" class="btn" name="login">Sign in</button>
				</div>
			</form>
		</div>
		<div class="tabcontent register-form display-none">
			<form action="RegisterUser" method="POST" id="register-form">
				<div class="form-group width-75 center-block">
					<input type="text" name="firstname" class="form-control"
						placeholder="First name" autofocus="autofocus" required="required"
						maxlength="30">
				</div>
				<div class="form-group width-75 center-block">
					<input type="text" name="lastname" class="form-control"
						placeholder="Last name" autofocus="autofocus" required="required"
						maxlength="30">
				</div>
				<div class="form-group width-75 center-block">
					<input type="text" name="username" class="form-control"
						placeholder="Username" autofocus="autofocus" required="required"
						maxlength="30">
				</div>
				<div class="form-group width-75 center-block">
					<input type="password" name="password" class="form-control"
						placeholder="Password" required="required" maxlength="30">
				</div>
				<div class="form-group width-75 center-block">
					<input type="email" name="email" class="form-control"
						placeholder="Email" required="required" maxlength="30">
				</div>
				<p class="errorMessage">${LoginError}</p>
				<div>
					<button type="submit" class="btn" name="register">Register</button>
				</div>
			</form>

		</div>

	</div>



	<script src="scripts/main.js"></script>
</body>
</html>