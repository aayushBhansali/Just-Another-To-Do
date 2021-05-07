<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="./css/login.css">
	<link rel="icon" type="image/png" href="./images/logo.png">
	<title>Login</title>
</head>
<body class="container">
	<header class="header">
		<div class="header-title">
			<div class="icon"></div>
			<div class="title">
				Just Another To-Do
			</div>
		</div>
		
		<nav class="navbar">
			<a href="/" class="nav-btn">Home</a>
			<a href="/signup" class="nav-btn">Sign Up</a>
		</nav>
	</header>
	
	<section class="login-section">
		<div class="login-background"></div>
		<div class="form-wrapper">
			<div class="login-header"> Login </div>
			<% String error = request.getParameter("error"); 
				if(error == null)
					error = "";
			%>
			
			
			<% if (error.equals("true")) { %>
				<div style="font-size: 1em; color: red; margin-bottom: 0.5em;"> Invalid Credentials </div>
			<% } %>
			
			
			<form class="form" action="login" method="POST">
				<input type="hidden" style="display: none;" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<label for="username"> Username : </label>
				<input class="input" type="text" name="username" />
				
				<label for="password"> Password : </label>
				<input class="input" type="password" name="password"/>
				
				<input type="submit" class="btn login-btn" value="Login" />
			</form>
		</div>
	</section>
	
	<footer class="footer">
		&copy Aayush Bhansali
	</footer>
</body>
</html>