<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fines</title>
</head>
<body>
<h1>Fines</h1>

<c:if test="${not empty fines}">
    <table border="1">
        <tr>
            <th>Penalty ID</th>
            <th>Validity</th>
            <th>Reason</th>
            <th>Penalty Date</th>
            <th>Expiration Date</th>
            <th>Librarian ID</th>
        </tr>
        <c:forEach var="penalty" items="${fines}">
            <tr>
                <td>${penalty.penaltyId}</td>
                <td>${penalty.validity}</td>
                <td>${penalty.reason}</td>
                <td>${penalty.penaltyDate}</td>
                <td>${penalty.expirationDate}"</td>
                <td>${penalty.librarianId}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty fines}">
    <p>No fines found.</p>
</c:if>
</body>
</html>
