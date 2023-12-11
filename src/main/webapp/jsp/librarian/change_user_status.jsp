<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Change User Status</title>
    <!-- Include your CSS and other necessary stylesheets -->
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container">
    <h2>Change User Status</h2>
    <!-- Your form to change user status goes here -->
    <form name="changeUserStatusForm" method="post" action="controller">
        <div class="form-group">
            <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId" required>
        </div>
        <div class="form-group">
            <label for="status">New Status:</label>
            <input type="text" id="status" name="status" required>
        </div>
        <div class="form-group">
            <button type="submit" name="action" value="change_user_status" class="btn btn-success">Change Status</button>
        </div>
    </form>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>
