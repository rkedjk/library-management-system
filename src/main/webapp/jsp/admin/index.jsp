<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Administrator Dashboard</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="admin/style.css">
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container">
    <h2>Administrator Dashboard</h2>
    <ul>
        <li><a href="add_book.jsp">Add New Book</a></li>
        <li><a href="view_users.jsp">View Users</a></li>
    </ul>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>
