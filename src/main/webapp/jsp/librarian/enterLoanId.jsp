<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enter Loan ID</title>
</head>
<body>
<h1>Enter Loan ID</h1>
<form action="controller" method="post">
    <input type="hidden" name="command" value="viewLoanDataCommand">
    <label for="loanId">Loan ID:</label>
    <input type="text" id="loanId" name="loanId"><br><br>
    <input type="submit" value="View and Edit Loan Data">
</form>
</body>
</html>
