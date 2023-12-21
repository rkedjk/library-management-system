<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Loans</title>
</head>
<body>
<h1>User Loans</h1>
<table border="1">
    <tr>
        <th>Loan ID</th>
        <!-- Add other loan details headers as needed -->
    </tr>
    <c:forEach var="loan" items="${loans}">
        <tr>
            <td>${loan.loanId}</td>
            <!-- Add other loan details as needed -->
        </tr>
    </c:forEach>
</table>
</body>
</html>
