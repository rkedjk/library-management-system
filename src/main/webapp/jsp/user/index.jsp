<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="user/style.css">
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container">
    <h2>User Dashboard</h2>
    <ul>
        <li><a href="search_books.jsp">Search Books</a></li>
        <li><a href="request_reservation.jsp">Request Reservation</a></li>
        <li><a href="view_history.jsp">View Borrowing History</a></li>
    </ul>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>
