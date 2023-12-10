<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Librarian Dashboard</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="librarian/style.css">
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container">
    <h2>Librarian Dashboard</h2>

    <form name="addNewBookForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="librariandashboard"/>
            <button type="submit" name="action" value="add_new_book" class="btn btn-success">Add New Book</button><br>
        </div>
    </form>

    <form name="updateBookDetailsForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="librariandashboard"/>
            <button type="submit" name="action" value="update_book_details" class="btn btn-success">Update Book Details</button><br>
        </div>
    </form>

    <form name="searchBooksForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="librariandashboard"/>
            <button type="submit" name="action" value="search_books" class="btn btn-success">Search Books</button><br>
        </div>
    </form>

    <form name="manageOrdersForm" method="post" action="controller">
        <div class="form-group col-md-3 offset-md-4 m-auto">
            <input type="hidden" name="command" value="librariandashboard"/>
            <button type="submit" name="action" value="manage_orders" class="btn btn-success">Manage Orders</button><br>
        </div>
    </form>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>
