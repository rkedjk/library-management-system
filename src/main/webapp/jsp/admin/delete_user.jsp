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
    <title>Delete User</title>
</head>
<body>
<h1>Delete User</h1>

<!-- Form for deleting a user -->
<form action="process_delete_user.jsp" method="post">
    <!-- Form fields to delete a user -->
    <label for="userId">User ID:</label>
    <input type="number" id="userId" name="userId" required><br><br>

    <input type="submit" value="Delete User">
</form>

</body>
</html>
