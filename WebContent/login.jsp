<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.1/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-4KIc2mnKfAA7VjirNLk2Sqp7jxFNq1q8+FhYGxhW2l52lt4HJsfksL+hjswHfbl/" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<h1 style ="color:black;margin-left:30px;text-align: center">UREC PLAY</h1>
</br>
</br>
	<h3 style = "text-align: center"><%out.print("Hello!"); %></h3>
	
	<%! int number1, number2; %>
	
	<%
		DbManager db = new DbManager();
		Connection conn = (Connection) db.getConnection();
		if(conn == null)
			out.print("failed");
		else
			//out.print("succeeded");
	
	%>
	
	
	<form  class = "container" name="loginform" action="LoginController" method="post" onsubmit="return loginValidate()" >
	<br>
	${message}<br>
	<div class="alert alert-dismissible alert-success container">
    <strong>${successMessage}</strong> 
	</div>
	<br>
	
	<div class = "form-group">
	User Email: <input class="form-control" type="text" name="username" id="username"><br>
	
	</div>
	<div class = "form-group">
	Password: <input class="form-control" type="password" name="password" id="password"><br>
	</div>

	<input class="btn btn btn-success" type="submit" name="submit" value="login" id ="login">

	<a class="btn btn btn-success" href="register.jsp">registration</a>
	
	</form>
	
</body>
</html>