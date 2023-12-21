<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Loan</title>
</head>
<body>
<h1>Create Loan</h1>
<form action="controller" method="post">
    <input type="hidden" name="command" value="createLoanCommand">

    <!-- Input fields for loan details -->
    <label for="inventoryId">Inventory ID:</label>
    <input type="text" id="inventoryId" name="inventoryId"><br><br>

    <label for="readerId">Reader ID:</label>
    <input type="text" id="readerId" name="readerId"><br><br>

    <label for="loanDate">Loan Date:</label>
    <input type="text" id="loanDate" name="loanDate" placeholder="YYYY-MM-DD"><br><br>

    <label for="dueDate">Due Date:</label>
    <input type="text" id="dueDate" name="dueDate" placeholder="YYYY-MM-DD"><br><br>

    <label for="status">Status:</label>
    <input type="text" id="status" name="status"><br><br>

    <input type="submit" value="Create Loan">
</form>
</body>
</html>
