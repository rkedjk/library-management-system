<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Search</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
<h2>Book Search</h2>
<form name="searchBooks" action="controller" method="post">
    <input type="hidden" name="command" value="searchBooksCommand">

    <label for="searchType">Search By:</label>
    <select name="searchType" id="searchType">
        <option value="id">ID</option>
        <option value="name">Name</option>
        <option value="genre">Genre</option>
        <option value="author">Author</option>
        <option value="publisher">Publisher</option>
    </select>
    <br><br>

    <input type="text" name="searchValue" id="searchValue">
    <br><br>

    <button type="submit" name="action" id="searchBooksBtn" value="Search" class="btn btn-success">Search</button><br>
</form>
</body>
</html>
