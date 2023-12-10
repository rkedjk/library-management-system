<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Books by Name</title>
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
        <a href="dashboard.jsp">Home</a>
        <a href="addBook.jsp">Add New Book</a>
        <!-- Add more navigation links as needed -->
    </div>
</nav>

<main>
    <div class="container">
        <h2>Search Books by Name</h2>
        <form action="SearchBookByNameServlet" method="get">
            <label for="bookName">Enter Book Name:</label>
            <input type="text" id="bookName" name="bookName" required>
            <input type="submit" value="Search">
        </form>

        <!-- Display search results using JSTL -->
        <c:if test="${not empty books}">
            <h3>Search Results:</h3>
            <c:forEach var="book" items="${books}">
                <p>Book Title: ${book.title}, Author: ${book.author}</p>
                <!-- Add more details as needed -->
            </c:forEach>
        </c:if>
    </div>
</main>

<footer>
    <div class="container">
        &copy; 2023 Library Management System
    </div>
</footer>

</body>
</html>
