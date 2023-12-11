<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="admin/style.css">
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container">
    <h2>Admin Dashboard</h2>

    <form name="manageUsersForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <button type="submit" name="action" value="searchuser" class="btn btn-success">Search Users</button><br>
        </div>
    </form>

    <form name="removeUserForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <button type="submit" name="action" value="deleteuser" class="btn btn-success">Remove User</button><br>
        </div>
    </form>

    <form name="addUserForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <button type="submit" name="action" value="adduser" class="btn btn-success">Add User</button><br>
        </div>
    </form>

    <form name="changeUserStatusForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <button type="submit" name="action" value="changestatus" class="btn btn-success">Change User Status</button><br>
        </div>
    </form>

    <button onclick="goBack()" class="btn btn-danger">Return to Previous Page</button>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>
