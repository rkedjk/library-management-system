<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Results - Books</title>
</head>
<body>
<h1>Search Results - Books</h1>
<table border="1">
    <tr>
        <th>Inventory ID</th>
        <th>Book ID</th>
        <th>Status</th>
        <th>Location</th>
        <!-- Add more table headers for other details if needed -->
    </tr>
    <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.inventoryId}</td>
            <td>${book.bookId}</td>
            <td>${book.status}</td>
            <td>${book.location}</td>
            <!-- Add more table data for other details if needed -->
        </tr>
    </c:forEach>
</table>
</body>
</html>
