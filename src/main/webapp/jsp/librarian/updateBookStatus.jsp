<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <input type="text" id="status" name="status"><br><br>

    <label for="inventoryId">Inventory ID:</label>
    <input type="text" id="inventoryId" name="inventoryId"><br><br>

    <input type="submit" value="Update Book Status">
</form>
</body>
</html>
