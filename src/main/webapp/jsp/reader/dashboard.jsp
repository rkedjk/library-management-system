<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Dashboard</title>
    <link rel="stylesheet" href="../../css/style.css">

</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container">
<h2>Welcome,</h2>
<c:set var="user" value="${requestScope.user}" />
<c:if test="${user ne null}">
    <p>${user.name}</p>
</c:if>
    <h2>User Dashboard</h2>

    <form name="dashboardForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="userdashboard">

            <button type="submit" name="action" value="search_books" class="btn btn-success">Search Books</button><br>
        </div>
    </form>

    <form name="requestReservationForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="userdashboard">
            <button type="submit" name="action" value="request_reservation" class="btn btn-success">Request Reservation</button><br>
        </div>
    </form>

    <form name="requestAvailableBooksForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="userdashboard">
            <button type="submit" name="action" value="request_available_books" class="btn btn-success">Request Available Books</button><br>
        </div>
    </form>

    <form name="reservationHistoryForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="userdashboard">
            <button type="submit" name="action" value="loans_history" class="btn btn-success">Loans History</button><br>
        </div>
    </form>

    <form name="rateBookForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="userdashboard">
            <button type="submit" name="action" value="rate_book" class="btn btn-success">Rate Book</button><br>
        </div>
    </form>


    <!-- New form for redirecting to requestFinesById.jsp -->
    <form name="requestFinesForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="userdashboard">
            <button type="submit" name="action" value="request_fines" class="btn btn-success">Request Fines</button><br>
        </div>
    </form>
    <button onclick="goBack()" class="btn btn-danger">Return to Previous Page</button>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>
