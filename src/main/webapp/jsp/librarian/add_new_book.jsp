<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Book</title>
</head>
<body>
<h1>Add New Book</h1>


<form action="add_new_book.jsp" method="post">

    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br><br>

    <label for="yearPublished">Year Published:</label>
    <input type="number" id="yearPublished" name="yearPublished"><br><br>

    <label for="authorId">Author ID:</label>
    <input type="number" id="authorId" name="authorId" required><br><br>

    <label for="genreId">Genre ID:</label>
    <input type="number" id="genreId" name="genreId" required><br><br>

    <label for="publisherId">Publisher ID:</label>
    <input type="number" id="publisherId" name="publisherId" required><br><br>

    <input type="submit" value="Add Book">
</form>

</body>
</html>
