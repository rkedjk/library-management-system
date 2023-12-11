
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<h1>Add User</h1>

<!-- Form for adding a new user -->
<form action="adduser.jsp" method="post">
    <!-- Form fields to add a new user -->
    <label for="type">User Type:</label>
    <select id="type" name="type">
        <option value="LIBRARIAN">Librarian</option>
        <option value="ADMIN">Admin</option>
        <option value="READER">Reader</option>
    </select><br><br>

    <label for="login">Login:</label>
    <input type="text" id="login" name="login" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="status">Status:</label>
    <select id="status" name="status">
        <option value="ACTIVE">Active</option>
        <option value="SUSPENDED">Suspended</option>
    </select><br><br>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <input type="submit" value="Add User">
</form>

</body>
</html>
