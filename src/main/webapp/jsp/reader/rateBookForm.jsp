<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Rate Book</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container">
    <h2>Rate Book</h2>

    <form name="rateBookForm" method="post" action="controller">
        <div class="form-group">
            <label for="bookId">Book ID:</label>
            <input type="text" id="bookId" name="bookId" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Rating:</label>
            <div>
                <button type="button" name="rating" value="like" class="btn btn-success">Like</button>
                <button type="button" name="rating" value="dislike" class="btn btn-danger">Dislike</button>
            </div>
        </div>

        <button type="submit" name="action" value="confirm_rating" class="btn btn-primary">Confirm</button>
    </form>

    <button onclick="goBack()" class="btn btn-secondary">Cancel</button>
</div>

<script>
    function goBack() {
        window.history.back();
    }
</script>

<%@ include file="../footer.jsp" %>
</body>
</html>
