<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Results - Book Catalog</title>
</head>
<body>
<h1>Search Results - Book Catalog</h1>
<table border="1">
    <tr>
        <th>Book ID</th>
        <th>Title</th>
        <th>Year Published</th>
        <th>Author</th>
        <th>Genre</th>
        <th>Publisher</th>
    </tr>
    <c:forEach items="${searchedBooks}" var="book">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.title}</td>
            <td>${book.yearPublished}</td>
            <td>${book.authorName}</td>
            <td>${book.genreName}</td>
            <td>${book.publisherName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
