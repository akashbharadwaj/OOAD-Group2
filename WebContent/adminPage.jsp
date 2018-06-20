<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<%out.print("Hello!"); %>
	<%= new java.util.Date() %>
	

	<br/>
	<h1> ${message} !!! </h1>
	<h1> Notifications </h1>
	<form name="pushmessage" action="admin" method="post"  >
	<br>
	
	Notification Message : <textarea rows="4" cols="50" name="message" id="message"></textarea><br>
	<input type="submit" name="submit" value="submit"><br>

	</form>
</body>
</html>