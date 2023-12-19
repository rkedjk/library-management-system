<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<h1>Add User</h1>
<form name="adduserform" action="controller" method="post">
    Type: <input type="text" name="type" /><br />
    Login: <input type="text" name="login" /><br />
    Password: <input type="password" name="password" /><br />
    Status: <input type="text" name="status" /><br />
    Name: <input type="text" name="name" /><br />
    <input type="submit" name="command" value="adduserform" />
</form>
</body>
</html>
