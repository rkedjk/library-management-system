<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Book Inventory</title>
</head>
<body>
<h1>Insert Book Inventory</h1>
<form action="controller" method="post">
    <input type="hidden" name="command" value="insertBookInventoryCommand">

    <!-- Input fields for book inventory details -->
    <label for="location">Location:</label>
    <input type="text" id="location" name="location"><br><br>

    <label for="status">Status:</label>
    <input type="text" id="status" name="status"><br><br>

    <label for="bookId">Book ID:</label>
    <input type="text" id="bookId" name="bookId"><br><br>

    <input type="submit" value="Insert Book Inventory">
</form>
</body>
</html>
