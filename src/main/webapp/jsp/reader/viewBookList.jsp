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
        <th>Name</th>
        <th>Author</th>
        <th>Genre</th>
        <th>Publisher</th>
        <th>Year Published</th>
        <!-- Add other relevant column headers -->
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${bookList}">
        <tr>
            <td>${book[0]}</td>
            <td>${book[1]}</td>
            <td>${book[3]}</td> <!-- Assuming index 3 for author -->
            <td>${book[4]}</td> <!-- Assuming index 4 for genre -->
            <td>${book[5]}</td> <!-- Assuming index 5 for publisher -->
            <td>${book[2]}</td> <!-- Assuming index 2 for year published -->
            <!-- Add other relevant columns -->
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
