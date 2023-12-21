<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Penalty Data</title>
</head>
<body>
<h1>Update Penalty Data</h1>
<form action="controller" method="post">
    <%
        Long penaltyId = (Long) request.getAttribute("penaltyId");
    %>
    <input type="hidden" name="command" value="updatePenaltyDataCommand">

    <!-- Display penalty data -->
    <label for="penaltyId">Penalty ID:</label>
    <input type="text" id="penaltyId" name="penaltyId" value="${penaltyData.penaltyId}" readonly><br><br>

    <label for="readerId">Reader ID:</label>
    <input type="text" id="readerId" name="readerId" value="${penaltyData.readerId}" readonly><br><br>

    <label for="validity">Validity:</label>
    <input type="text" id="validity" name="validity" value="${penaltyData.validity}"><br><br>

    <label for="reason">Reason:</label>
    <input type="text" id="reason" name="reason" value="${penaltyData.reason}"><br><br>

    <label for="penaltyDate">Penalty Date:</label>
    <input type="text" id="penaltyDate" name="penaltyDate" value="${penaltyData.penaltyDate}"><br><br>

    <label for="expirationDate">Expiration Date:</label>
    <input type="text" id="expirationDate" name="expirationDate" value="${penaltyData.expirationDate}"><br><br>

    <!-- Assuming librarian ID comes from session -->
    <input type="hidden" name="librarianId" value="${sessionScope.user.id}">

    <input type="submit" value="Update Penalty Data">
</form>

</body>
</html>
