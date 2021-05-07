<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "sf"%>
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
			
			<div style="font-size: 1em; color: red; margin-bottom: 0.5em;">${error}</div>
			
			<form class="form" action="todo/show">
				<label path="username"> Username : </label>
				<input class="input" type="text" path="username" />
				
				<label path="password"> Password : </label>
				<input class="input" type="password" path="password"/>
				
				<input type="submit" class="btn login-btn" value="Login" />
			</form>
		</div>
	</section>
	
	<footer class="footer">
		&copy Aayush Bhansali
	</footer>
</body>
</html>