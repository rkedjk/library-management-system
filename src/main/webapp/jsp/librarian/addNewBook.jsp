<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Book Catalog</title>
</head>
<body>
<h1>Insert Book Catalog</h1>
<form action="controller" method="post">
    <input type="hidden" name="command" value="insertBookCatalogCommand">

    <!-- Input fields for inserting book catalog details -->
    <label for="title">Title:</label>
    <input type="text" id="title" name="title"><br><br>

    <label for="yearPublished">Year Published:</label>
    <input type="number" id="yearPublished" name="yearPublished"><br><br>

    <label for="authorName">Author Name:</label>
    <input type="text" id="authorName" name="authorName"><br><br>

    <label for="genreName">Genre Name:</label>
    <input type="text" id="genreName" name="genreName"><br><br>

    <label for="publisherName">Publisher Name:</label>
    <input type="text" id="publisherName" name="publisherName"><br><br>

    <input type="submit" value="Insert Book Catalog">
</form>
</body>
</html>
