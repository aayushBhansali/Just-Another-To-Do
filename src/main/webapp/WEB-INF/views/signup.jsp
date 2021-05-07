<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "sf"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="./css/login.css">
	<link rel="stylesheet" href="./css/signup.css">
	<link rel="icon" type="image/png" href="./images/logo.png">
	<title>Sign up</title>
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
			<a href="/login" class="nav-btn">Login</a>
		</nav>
	</header>
	
	<section class="signup-section">
		<div class="signup-background"></div>
		<div class="form-wrapper signup-wrapper">
			<div class="login-header"> Sign up </div>
			
			<div style="font-size: 1em; color: red; margin-bottom: 0.5em;">${error}</div>
			
			<sf:form class="form" action="signup" method="POST" modelAttribute="user">
				<sf:label path="username"> Username : </sf:label>
				<sf:input class="input-signup" path="username" type="text" />
				
				<sf:label path="username"> Email : </sf:label>
				<sf:input class="input-signup" path="email" type="email" />
				
				<sf:label path="password"> Password : </sf:label>
				<sf:input class="input-signup" path="password" type="password" />
				
				<input class="btn signup-btn" type="submit" value="Submit"></input>
			</sf:form>
		</div>
	</section>
	
	<footer class="footer">
		&copy Aayush Bhansali
	</footer>
</body>
</html>