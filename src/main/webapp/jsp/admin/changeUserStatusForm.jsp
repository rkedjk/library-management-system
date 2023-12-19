<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Change User Status</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="admin/style.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <h2>Change User Status</h2>
    <form name="changeUserStatusForm" method="post" action="controller">
        <input type="hidden" name="command" value="admindashboard"/>
        <input type="hidden" name="action" value="changestatus"/>
        <p>Enter the user ID of the user whose status you want to change:</p>
        <input type="text" name="userId" required>
        <select name="status" required>
            <option value="active">Active</option>
            <option value="inactive">Inactive</option>
        </select>
        <button type="submit" class="btn btn-success">Change Status</button>
    </form>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>