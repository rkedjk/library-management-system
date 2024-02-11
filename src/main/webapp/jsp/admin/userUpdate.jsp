<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Update</title>
</head>
<body>
<h1>User Update</h1>
<c:set var="user" value="${requestScope.user}" />

<form name="adduserform" action="controller" method="post">
    Type:
    <select name="type">
        <option value="ADMIN">ADMIN</option>
        <option value="READER">READER</option>
        <option value="LIBRARIAN">LIBRARIAN</option>
    </select><br />
    Login: <input type="text" name="login" /><br />
    Password: <input type="password" name="password" /><br />
    Status:
    <select name="status">
        <option value="ACTIVE">ACTIVE</option>
        <option value="SUSPENDED">SUSPENDED</option>
    </select><br />
    Name: <input type="text" name="name" /><br />
    <input type="submit" name="command" value="adduserform" />
</form>

</body>
</html>
