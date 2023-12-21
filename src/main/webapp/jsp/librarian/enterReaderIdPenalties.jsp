<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enter Reader ID for Penalties</title>
</head>
<body>
<h1>Enter Reader ID for Penalties</h1>
<form action="controller" method="post">
    <input type="hidden" name="command" value="viewPenaltiesByReaderCommand">

    <label for="readerId">Reader ID:</label>
    <input type="text" id="readerId" name="readerId"><br><br>

    <input type="submit" value="View Penalties">
</form>
</body>
</html>
