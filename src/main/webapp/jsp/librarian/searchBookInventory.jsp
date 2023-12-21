<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Books</title>
</head>
<body>
<h1>Search Books</h1>
<form action="controller" method="post">
    <input type="hidden" name="command" value="searchBooksInventoryCommand">

    <label for="searchType">Search Type:</label>
    <select id="searchType" name="searchType">
        <option value="inventory_id">Inventory ID</option>
        <option value="status">Status</option>
        <option value="book_id">Book ID</option>
    </select><br><br>

    <label for="searchValue">Search Value:</label>
    <input type="text" id="searchValue" name="searchValue"><br><br>

    <input type="submit" value="Search">
</form>
</body>
</html>
