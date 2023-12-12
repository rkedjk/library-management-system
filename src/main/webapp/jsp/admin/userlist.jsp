<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.rsreu.library.databaseutil.entity.Account"%>
<html>
<head>
    <title>User Management - User List</title>
    <!-- Add your CSS file link here -->
    <link rel="stylesheet" href="path_to_your_css_file/style.css">
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>Login</th>
        <th>Password</th>
        <th>Status</th>
        <th>Name</th>
        <!-- Add more columns as needed -->
    </tr>
    </thead>
    <tbody>
    <c:forEach var="account" items="${userList}">
        <tr>
            <td><c:out value="${account.id}" /></td>
            <td><c:out value="${account.type}" /></td>
            <td><c:out value="${account.login}" /></td>
            <td><c:out value="${account.password}" /></td>
            <td><c:out value="${account.status}" /></td>
            <td><c:out value="${account.name}" /></td>
            <!-- Add more columns as needed -->
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Add additional forms/buttons/links as required -->
</body>
</html>
