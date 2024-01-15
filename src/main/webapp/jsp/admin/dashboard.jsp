<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="admin/style.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <h2>Welcome,</h2>
    <c:set var="user" value="${requestScope.user}" />
    <c:if test="${user ne null}">
        <p>${user.name}</p>
    </c:if>
    <h2>Admin Dashboard</h2>

    <form name="addUserForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <label for="addUserBtn">Add User:</label>
            <button type="submit" name="action" id="addUserBtn" value="adduser" class="btn btn-success">Add User</button><br>
        </div>
    </form>


    <form name="manageUsersForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <label for="searchUserBtn">Search Users:</label>
            <button type="submit" name="action" id="searchUserBtn" value="searchuser" class="btn btn-success">Search</button><br>
        </div>
    </form>

    <form name="viewUsersForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <label for="viewUserListBtn">View User List:</label>
            <button type="submit" name="action" id="viewUserListBtn" value="userlist" class="btn btn-success">View</button><br>
        </div>
    </form>

    <form name="updateUserForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <label for="updateUserCredBtn">Update User Credentials:</label>
            <button type="submit" name="action" id="updateUserCredBtn" value="userupdate" class="btn btn-success">Update</button><br>
        </div>
    </form>

    <form name="removeUserForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <label for="deleteUserBtn">Delete User:</label>
            <button type="submit" name="action" id="deleteUserBtn" value="deleteuser" class="btn btn-success">Delete</button><br>
        </div>
    </form>

    <button onclick="goBack()" class="btn btn-danger">Return to Previous Page</button>

    <script>
        function goBack() {
            window.history.back();
        }

        // Basic input validation
        function validateForm() {
            let form = event.target.form;
            let command = form.command.value;
            let action = form.action.value;

            if (command === "admindashboard" && (!action || action === "")) {
                alert("Please select an action.");
                event.preventDefault();
                return false;
            }
        }

        // Attach validateForm function to all forms
        for (let form of document.getElementsByTagName("form")) {
            form.addEventListener("submit", validateForm);
        }
    </script>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>