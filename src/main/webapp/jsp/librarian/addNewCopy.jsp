<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Book Catalog</title>
</head>
<body>
<h1>Insert Book Catalog</h1>
<form name="insertBookCatalog" action="controller" method="post">
    Title: <input type="text" name="title" required /><br />
    Year Published: <input type="text" name="yearPublished" required /><br />
    Author Name: <input type="text" name="authorName" required /><br />
    Genre Name: <input type="text" name="genreName" required /><br />
    Publisher Name: <input type="text" name="publisherName" required /><br />
    <input type="submit" name="command" value="insertBookCatalog" />
</form>
</body>
</html>
