<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete User by ID</title>
</head>
<body>
<h1>Delete User by ID</h1>
<form name="deleteuserbyid" action="controller" method="post">
    User ID: <input type="text" name="userId" required /><br />
    <input type="submit" name="command" value="deleteuserbyid" />
</form>
</body>
</html>
