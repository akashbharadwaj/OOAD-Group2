<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.1/lux/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4KIc2mnKfAA7VjirNLk2Sqp7jxFNq1q8+FhYGxhW2l52lt4HJsfksL+hjswHfbl/"
	crossorigin="anonymous">
<title>Welcome Page</title>
</head>
<body>
	<h1 style="color: black; margin-left: 30px; text-align: center">UREC
		PLAY</h1>

	<a class="btn btn btn-danger" href="logout.jsp">logout</a>
	<a id="history" class="btn btn btn-danger"
		href="${pageContext.request.contextPath}/BookingController?Uid=<c:out value="${user}"/>&show=1">Booking</a>
	<h3 style="text-align: center">${message1} !!!</h3>

	<form action="ArenaController?Uid=<c:out value="${user}"/>" method="post">
		<br>
		<div class="form-group">
			Search: <input class="form-control" name="searchString" id="searchString"></input><br>
		</div>
		<div class="form-group">
			<input class="btn btn btn-success" type="submit" name="submit"
				value="search"><br>
		</div>
	</form>

	<h3 align="center">Arenas to book</h3>

	<table border=1 align="center" id="page">
		<thead>
			<tr>
				<th>Arena ID</th>
				<th>Name</th>
				<th>Location</th>
				<th>Book</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${arenas}" var="arenas">
				<tr>
					<td><c:out value="${arenas.arenaID}" /></td>
					<td><c:out value="${arenas.name}" /></td>
					<td><c:out value="${arenas.location}" /></td>
					<td><a class="btn btn-success" id="${arenas.arenaID}"
						href="${pageContext.request.contextPath}/BookingController?Uid=<c:out value="${user}"/>&Aid=<c:out value="${arenas.arenaID}"/>&show=0">Book</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>