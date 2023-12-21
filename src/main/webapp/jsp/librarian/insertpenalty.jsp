<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Penalty</title>
</head>
<body>
<h1>Insert Penalty</h1>
<form action="controller" method="post">
    <input type="hidden" name="command" value="insertPenaltyCommand">

    <!-- Input fields for penalty details -->
    <label for="readerId">Reader ID:</label>
    <input type="text" id="readerId" name="readerId"><br><br>

    <label for="validity">Validity:</label>
    <input type="text" id="validity" name="validity"><br><br>

    <label for="reason">Reason:</label>
    <input type="text" id="reason" name="reason"><br><br>

    <label for="penaltyDate">Penalty Date:</label>
    <input type="text" id="penaltyDate" name="penaltyDate" placeholder="YYYY-MM-DD"><br><br>

    <label for="expirationDate">Expiration Date:</label>
    <input type="text" id="expirationDate" name="expirationDate" placeholder="YYYY-MM-DD"><br><br>

    <input type="submit" value="Insert Penalty">
</form>
</body>
</html>
