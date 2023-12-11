<%--
  Created by IntelliJ IDEA.
  User: rkedj
  Date: 11.12.2023
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Change User Status</title>
</head>
<body>
<h1>Change User Status</h1>

<!-- Form for changing user status -->
<form action="change_status.jsp" method="post">
    <!-- Form fields to change user status -->
    <label for="userId">User ID:</label>
    <input type="number" id="userId" name="userId" required><br><br>

    <label for="newStatus">New Status:</label>
    <select id="newStatus" name="newStatus">
        <option value="ACTIVE">Active</option>
        <option value="SUSPENDED">Suspended</option>
    </select><br><br>

    <input type="submit" value="Change Status">
</form>

</body>
</html>
