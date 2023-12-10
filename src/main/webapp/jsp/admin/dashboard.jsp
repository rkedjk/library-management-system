<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="admin/style.css">
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container">
    <h2>Admin Dashboard</h2>

    <form name="manageUsersForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <button type="submit" name="action" value="add_user" class="btn btn-success">Add User</button><br>
        </div>
    </form>

    <form name="removeUserForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <button type="submit" name="action" value="remove_user" class="btn btn-success">Remove User</button><br>
        </div>
    </form>

    <form name="manageBooksForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <button type="submit" name="action" value="add_new_book" class="btn btn-success">Add New Book</button><br>
        </div>
    </form>

    <form name="removeBookForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <button type="submit" name="action" value="remove_book" class="btn btn-success">Remove Book</button><br>
        </div>
    </form>

    <form name="updateBookInfoForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="admindashboard"/>
            <button type="submit" name="action" value="update_book_info" class="btn btn-success">Update Book Info</button><br>
        </div>
    </form>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>
