<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Librarian Dashboard</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="librarian/style.css">
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container">
    <h2>Librarian Dashboard</h2>
    <ul>
        <li><a href="issue_book.jsp">Issue Book</a></li>
        <li><a href="return_book.jsp">Return Book</a></li>
        <li><a href="view_inventory.jsp">View Inventory</a></li>
        <li><a href="new_book.jsp">Add Book</a></li>
    </ul>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>
