<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Entity</title>
</head>
<body>
<h1>Insert Entity</h1>
<form action="controller" method="post">
    <input type="hidden" name="command" value="insertEntityCommand">

    <!-- Input fields for inserting entity details -->
    <label for="entityType">Entity Type:</label>
    <select id="entityType" name="entityType">
        <option value="author">Author</option>
        <option value="genre">Genre</option>
        <option value="publisher">Publisher</option>
    </select><br><br>

    <label for="entityName">Entity Name:</label>
    <input type="text" id="entityName" name="entityName"><br><br>

    <input type="submit" value="Insert Entity">
</form>
</body>
</html>
