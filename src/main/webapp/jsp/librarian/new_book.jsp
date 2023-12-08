<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Book</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<header>
    <div class="container">
        <h1>Library Management System</h1>
    </div>
</header>

<nav>
    <div class="container">
        <a href="index.jsp">Home</a>
        <a href="addBook.jsp">Add New Book</a>
        <!-- Add more navigation links as needed -->
    </div>
</nav>

<main>
    <div class="container">
        <h2>Add New Book</h2>
        <form action="AddBookServlet" method="post">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required><br><br>

            <label for="author">Author:</label>
            <input type="text" id="author" name="author" required><br><br>

            <label for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn" required><br><br>

            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" required><br><br>

            <input type="submit" value="Add Book">
        </form>
    </div>
</main>

<footer>
    <div class="container">
        &copy; 2023 Library Management System
    </div>
</footer>

</body>
</html>
