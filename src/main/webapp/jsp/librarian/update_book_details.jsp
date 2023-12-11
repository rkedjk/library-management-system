<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Book Details</title>
</head>
<body>
<h1>Update Book Details</h1>

<!-- Form for updating book details -->
<form action="update_book_details.jsp" method="post">
    <!-- Form fields to update book details -->
    <label for="bookId">Book ID:</label>
    <input type="number" id="bookId" name="bookId" required><br><br>

    <label for="title">Title:</label>
    <input type="text" id="title" name="title"><br><br>

    <label for="yearPublished">Year Published:</label>
    <input type="number" id="yearPublished" name="yearPublished"><br><br>

    <label for="authorId">Author ID:</label>
    <input type="number" id="authorId" name="authorId"><br><br>

    <label for="genreId">Genre ID:</label>
    <input type="number" id="genreId" name="genreId"><br><br>

    <label for="publisherId">Publisher ID:</label>
    <input type="number" id="publisherId" name="publisherId"><br><br>

    <input type="submit" value="Update Book Details">
</form>

</body>
</html>
