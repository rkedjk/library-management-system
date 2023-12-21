<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>\
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reader's Loans</title>
</head>
<body>
<h1>Reader's Loans</h1>
<table border="1">
    <tr>
        <th>Loan ID</th>
        <th>Inventory ID</th>
        <th>Reader ID</th>
        <th>Loan Date</th>
        <th>Due Date</th>
        <th>Return Date</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${readerLoans}" var="loan">
        <tr>
            <td>${loan.loanId}</td>
            <td>${loan.inventoryId}</td>
            <td>${loan.readerId}</td>
            <td>${loan.loanDate}</td>
            <td>${loan.dueDate}</td>
            <td>${loan.returnDate}</td>
            <td>${loan.status}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
