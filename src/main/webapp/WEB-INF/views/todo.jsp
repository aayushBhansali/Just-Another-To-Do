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
			<a href="/logout" class="nav-btn">Logout</a>
		</nav>
	</header>
	
	<section class="landing-section">
		<div class="content-wrapper">
			<div class="task-list">
				<div class="task-header">
					Pending Tasks
				</div>
				
				<div class="list-container">
					<c:forEach items="${pendingTasks }" var="task">
						<div class="list-item">
							<p class="todo-text"> ${task.getTask() } </p>
							<form class="btn-form" method="POST" action="/todo/remove">
								<input type="hidden" style="display: none;" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<input type="hidden" style="display: none;" name="id" value=${task.getId() }></input>
								<button class="remove-icon" type="submit"><i class="fa fa-trash" style="color: white; font-size: 1.5em;"></i></button>
							</form>
						</div>
					</c:forEach>
				</div>
			</div>
			
			<div class="task-list">
				<div class="task-header">
					Today's Tasks 
				</div>
				
				<div class="list-container">
					<c:forEach items="${todaysTasks }" var="task">
						<div class="list-item">
							<p class="todo-text"> ${task.getTask() } </p>
							<form class="btn-form" method="POST" action="/todo/remove">
								<input type="hidden" style="display: none;" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<input type="hidden" style="display: none;" name="id" value=${task.getId() }></input>
								<button class="remove-icon" type="submit"><i class="fa fa-trash" style="color: white; font-size: 1.5em;"></i></button>
							</form>
						</div>
					</c:forEach>
				</div>
			</div>
			
			<div class="task-list">
				<div class="form-wrapper">
					<form class="task-form" action="/todo/add" method = "POST">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<label for="newtask"> Add a new task : </label>
						<input class="input" name="title" type="text" />
						<input class="btn add-btn" type="submit" value="Add Task"/>
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