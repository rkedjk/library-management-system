<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book List</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
<h2>Book List</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Genre</th>
        <th>Publisher</th>
        <th>Year Published</th>
        <th>Rating</th>
        <!-- Add other relevant column headers -->
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${bookList}">
        <tr>
            <td>${book.book.bookId}</td>
            <td>${book.book.title}</td>
            <td>${book.book.authorName}</td>
            <td>${book.book.genreName}</td>
            <td>${book.book.publisherName}</td>
            <td>${book.book.yearPublished}</td>
            <td>${book.rating}</td>
            <!-- Add other relevant columns -->
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
