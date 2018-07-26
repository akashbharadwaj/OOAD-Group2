<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.1/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-4KIc2mnKfAA7VjirNLk2Sqp7jxFNq1q8+FhYGxhW2l52lt4HJsfksL+hjswHfbl/" crossorigin="anonymous">
<title>Booking History</title>
</head>
<body>
<h1 style ="color:black;margin-left:30px;text-align: center">UREC PLAY</h1>

<a class="btn btn btn-danger" href="logout.jsp">logout</a>
<h3 style="text-align:center"> Booking History</h3>

   <table border=1 align="center" id="page">
        <thead>
            <tr>
                <th>Arena ID</th>
                <th>Arena Name</th>
                <th>Slot</th>
                <th>Cancel</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${bookings}" var="booking">
                <tr>
                    <td><c:out value="${booking.arenaId}"/></td>
                    <td><c:out value="${booking.arenaName}"/></td>
                    <td><c:out value="${booking.slotTime}:00 - ${booking.slotTime+1}:00"/></td>
                    <td><a id = "${booking.bookingId}" class = "btn btn-danger" href="${pageContext.request.contextPath}/BookingController?Uid=<c:out value="${user}"/>&Bid=<c:out value="${booking.bookingId}"/>&show=2">Cancel</a></td>
				</tr>
            </c:forEach>
        </tbody>
    </table> 


</body>
</html>