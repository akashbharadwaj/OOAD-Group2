<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.1/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-4KIc2mnKfAA7VjirNLk2Sqp7jxFNq1q8+FhYGxhW2l52lt4HJsfksL+hjswHfbl/" crossorigin="anonymous">
<title>Welcome Page</title>
</head>
<body>
<h1 style ="color:black;margin-left:30px;text-align: center">UREC PLAY</h1>

<a class="btn btn btn-danger" href="logout.jsp">logout</a>
<h3 style="text-align:center"> ${message1} !!! </h3>
<h3 align="center">Arenas to book</h3>

${arenas} 


</body>
</html>