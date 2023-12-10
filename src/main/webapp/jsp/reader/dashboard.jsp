<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <form name="dashboardForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="userdashboard"/>

            <button type="submit" name="action" value="search_books" class="btn btn-success">Search Books</button><br>
        </div>
    </form>

    <form name="requestReservationForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="userdashboard"/>
            <button type="submit" name="action" value="request_reservation" class="btn btn-success">Request Reservation</button><br>
        </div>
    </form>

    <form name="requestAvailableBooksForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="userdashboard"/>
            <button type="submit" name="action" value="request_available_books" class="btn btn-success">Request Available Books</button><br>
        </div>
    </form>

    <form name="reservationHistoryForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="userdashboard"/>
            <button type="submit" name="action" value="reservation_history" class="btn btn-success">Loans History</button><br>
        </div>
    </form>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>
