<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.1/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-4KIc2mnKfAA7VjirNLk2Sqp7jxFNq1q8+FhYGxhW2l52lt4HJsfksL+hjswHfbl/" crossorigin="anonymous">
</head>
<body>
<h1 style ="color:black;margin-left:30px;text-align: center">UREC PLAY</h1>

<form class="container" name="regform" action="LoginController" method="post" onsubmit="return regValidate()">
	<br>${message}<br>
	<div class= "form-group">
	User Email: <input class="form-control" type="text" name="username"> <br>
	</div>
	<div id="username_error"></div><br>
	<div class= "form-group">
	Customer name: <input class="form-control" type="text" name="name"><br>
	</div>
	<div class= "form-group">
	Customer age: <input class="form-control" type="number" name="age"><br>
	</div>
	<div class= "form-group">
	Customer gender: <input class="form-control" type="text" name="gender"><br>
	</div>
	<div class= "form-group">
	Password: <input class="form-control" type="password" name="password" id="password"> 
	</div>
	<br>
	Re-Type Password: <input class="form-control" type="password" name="retry-password" id="retry-password"> 
	<br>
	<div id="password_error"></div><br>
	<input type="submit" name="submit" class="btn btn btn-success" value="register" >
	<input type="reset" name="reset" class="btn btn btn-success">
	
	</form>
	<a href="login.jsp">login</a>
	
</body>
</html>