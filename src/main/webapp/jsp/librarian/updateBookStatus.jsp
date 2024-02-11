<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Book Status</title>
</head>
<body>
<h1>Update Book Status</h1>
<form action="controller" method="post">
    <input type="hidden" name="command" value="updateBookStatusCommand">

    <!-- Input fields for updating book status -->
    <label for="status">Status:</label>
    <select id="status" name="status">
        <option value="LOST">LOST</option>
        <option value="AVAILABLE">AVAILABLE</option>
        <option value="ON_REPAIR">ON_REPAIR</option>
        <option value="SCRAPPED">SCRAPPED</option>
        <option value="RESERVED">RESERVED</option>
    </select><br><br>

    <label for="inventoryId">Inventory ID:</label>
    <input type="text" id="inventoryId" name="inventoryId"><br><br>

    <input type="submit" value="Update Book Status">
</form>

</body>
</html>
