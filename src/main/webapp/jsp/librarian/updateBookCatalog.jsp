<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Book Catalog - Enter Book ID</title>
</head>
<body>
<h1>Enter Book ID</h1>
<form name="enterBookId" action="controller" method="post">
    Enter Book ID: <input type="text" name="bookId" required /><br />
    <input type="submit" name="command" value="displayBookData" />
</form>
</body>
</html>
