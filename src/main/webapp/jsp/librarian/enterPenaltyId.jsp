<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enter Penalty ID</title>
</head>
<body>
<h1>Enter Penalty ID</h1>
<form action="controller" method="post">
    <input type="hidden" name="command" value="viewPenaltyDataCommand">
    <label for="penaltyId">Penalty ID:</label>
    <input type="text" id="penaltyId" name="penaltyId"><br><br>
    <input type="submit" value="View Penalty Data">
</form>
</body>
</html>
