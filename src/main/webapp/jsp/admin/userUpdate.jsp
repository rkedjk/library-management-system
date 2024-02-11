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
        Login: <input type="text" name="login" value="${user.login}" /><br />
        Password: <input type="password" name="password" value="${user.password}" /><br />
        Status:
        <select name="status">
            <c:choose>
                <c:when test="${user.status eq 'ACTIVE'}">
                    <option value="ACTIVE" selected>ACTIVE</option>
                    <option value="SUSPENDED">SUSPENDED</option>
                </c:when>
                <c:otherwise>
                    <option value="ACTIVE">ACTIVE</option>
                    <option value="SUSPENDED" selected>SUSPENDED</option>
                </c:otherwise>
            </c:choose>
        </select><br />
        Name: <input type="text" name="name" value="${user.name}" /><br />
        <input type="submit" name="command" value="userupdate" />
    </form>
</c:if>

</body>
</html>
