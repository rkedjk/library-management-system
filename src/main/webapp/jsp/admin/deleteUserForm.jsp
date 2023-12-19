<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirm User Deletion</title>
</head>
<body>
<h1>Confirm User Deletion</h1>
<c:set var="user" value="${requestScope.user}" />

<c:if test="${user ne null}">
    <p>Are you sure you want to delete the following user?</p>
    <p>User ID: ${user.id}</p>
    <p>Type: ${user.type}</p>
    <p>Login: ${user.login}</p>
    <p>Password: ${user.password}</p>
    <p>Status: ${user.status}</p>
    <p>Name: ${user.name}</p>
    <form name="deleteuserform" action="controller" method="post">
        <input type="hidden" name="userId" value="${user.id}" />
        <input type="submit" name="command" value="deleteuserform" />
    </form>
</c:if>
</body>
</html>
