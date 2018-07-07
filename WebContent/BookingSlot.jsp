<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BookingController?Aid=<c:out value="${arena}"/>&Uid=<c:out value="${user}"/>" method="post">
	<select name = "timeslot">
	     <c:forEach items="${li}" var="el">
	             <option value = <c:out value="${el}"/>><c:out value="${el}"/>:00 - <c:out value="${el+1}"/>:00</option>
	     </c:forEach>
	</select>
	<button type = "submit"> Book </button>
</form>
</body>
</html>