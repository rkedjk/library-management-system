<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>View and Edit Loan Data</title>
</head>
<body>
<h1>Loan Data</h1>
<form action="controller" method="post">
    <input type="hidden" name="command" value="updateLoanDataCommand">

    <!-- Display loan data for editing -->
    <label for="loanId">Loan ID:</label>
    <input type="text" id="loanId" name="loanId" value="${loanData.loanId}" readonly><br><br>

    <label for="inventoryId">Inventory ID:</label>
    <input type="text" id="inventoryId" name="inventoryId" value="${loanData.inventoryId}"><br><br>

    <label for="readerId">Reader ID:</label>
    <input type="text" id="readerId" name="readerId" value="${loanData.readerId}"><br><br>

    <label for="loanDate">Loan Date:</label>
    <input type="date" id="loanDate" name="loanDate" value="${loanData.loanDate}"><br><br>

    <label for="dueDate">Due Date:</label>
    <input type="date" id="dueDate" name="dueDate" value="${loanData.dueDate}"><br><br>

    <label for="status">Status:</label>
    <input type="text" id="status" name="status" value="${loanData.status}"><br><br>

    <label for="returnDate">Return Date:</label>
    <input type="date" id="returnDate" name="returnDate" value="${loanData.returnDate}"><br><br>

    <input type="submit" value="Update Loan Data">
</form>
</body>
</html>
