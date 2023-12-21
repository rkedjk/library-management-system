<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Available Books</title>
</head>
<body>
<h1>Available Books</h1>
<table border="1">
    <tr>
        <th>Book ID</th>
        <th>Title</th>
        <th>Year Published</th>
        <th>Author</th>
        <th>Genre</th>
        <th>Publisher</th>
    </tr>
    <c:forEach items="${availableBooks}" var="book">
        <tr>
            <td>${book[0]}</td>
            <td>${book[1]}</td>
            <td>${book[2]}</td> <!-- Assuming index 3 for author -->
            <td>${book[3]}</td> <!-- Assuming index 4 for genre -->
            <td>${book[4]}</td> <!-- Assuming index 5 for publisher -->
            <td>${book[5]}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
