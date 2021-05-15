<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="../css/todo.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="icon" type="image/png" href="../images/logo.png">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="../js/index.js"> </script>
	
	<title>To-Do</title>
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
			<a href="/logout" class="nav-btn"><i class="fa fa-sign-out" style="padding: 1em; font-size: 1.2	em;"></i>Logout</a>
		</nav>
	</header>
	
	<section class="landing-section">
		<div class="content-wrapper">
			<div class="task-list">
				<div class="task-header">
					Pending Tasks
				</div>
				
				<div class="list-container" id="pendingTasks"></div>
			</div>
			
			<div class="task-list">
				<div class="task-header">
					Today's Tasks 
				</div>
				
				<div class="list-container" id = "todayTasks"></div>
			</div>
			
			<div class="task-list">
				<div class="form-wrapper">
					<form class="task-form" method = "POST" id="addForm">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<label for="newtask"> Add a new task : </label>
						<input id="add" class="input" name="title" type="text" required/>
						<button class="btn add-btn" type="submit" onclick="addTask()"> Add Task </button>
					</form>
				</div>
			</div>
		</div>
	</section>
	
	
	<footer class="footer">
		&copy Aayush Bhansali
	</footer>
</body>
</html>