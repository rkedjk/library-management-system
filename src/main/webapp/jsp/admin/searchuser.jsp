<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Management - Search</title>
    <!-- Add your CSS file link here -->
    <link rel="stylesheet" href="path_to_your_css_file/style.css">
</head>
<body>
<form name="searchForm" method="GET" action="userlist">
    <label for="searchInput">Search:</label>
    <input type="text" id="searchInput" name="searchInput">

    <label for="searchParam">Search By:</label>
    <select id="searchParam" name="searchParam">
        <option value="id">ID</option>
        <option value="name">Name</option>
        <option value="type">Type</option>
        <option value="status">Status</option>
        <!-- Add more options if needed -->
    </select>

    <input type="submit" value="Search">
</form>
</body>
</html>
