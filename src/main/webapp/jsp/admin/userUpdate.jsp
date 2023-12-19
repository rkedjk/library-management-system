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

<c:if test="${user ne null}">
    <form name="userupdate" action="controller"  method="post">
        <input type="hidden" name="userId" value="${user.id}" />
        Type: <input type="text" name="type" value="${user.type}" /><br />
        Login: <input type="text" name="login" value="${user.login}" /><br />
        Password: <input type="password" name="password" value="${user.password}" /><br />
        Status: <input type="text" name="status" value="${user.status}" /><br />
        Name: <input type="text" name="name" value="${user.name}" /><br />
        <input type="submit" name="command" value="userupdate" />
    </form>
</c:if>
</body>
</html>
