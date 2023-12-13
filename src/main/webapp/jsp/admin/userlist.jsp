<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="org.rsreu.library.databaseutil.DAO.admin.UserDAO" %>
<%@ page import="org.rsreu.library.databaseutil.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.rsreu.library.databaseutil.OracleConnectionManager" %>

<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>

<%
        UserDAO userDAO = new UserDAO(OracleConnectionManager.getConnection()); // Initialize your UserDAO here

        // Get all users from the database
        List<User> userList = userDAO.getAllUsers();
%>

<!-- Display all users in a table -->
<!-- Display all users in a table -->
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>Login</th>
        <th>Status</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <% for (User user : userList) { %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getType() %></td>
        <td><%= user.getLogin() %></td>
        <td><%= user.getStatus() %></td>
        <td><%= user.getName() %></td>
    </tr>
    <% } %>
    </tbody>
</table>

</body>
</html>