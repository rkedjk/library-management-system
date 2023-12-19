<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
    <link rel="stylesheet" href="../../css/style.css">
    <!-- Any necessary styles or scripts -->
</head>
<body>
<h2>User List</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Type</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.type}</td>
            <td>${user.status}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
