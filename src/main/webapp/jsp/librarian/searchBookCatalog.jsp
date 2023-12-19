<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Book Catalog</title>
</head>
<body>
<h1>Search Book Catalog</h1>
<form name="searchBookCatalog" action="controller" method="post">
    Search Type:
    <select name="searchType">
        <option value="id">ID</option>
        <option value="publisher">Publisher</option>
        <option value="year_published">Year Published</option>
        <option value="genre">Genre</option>
        <option value="author">Author</option>
        <option value="title">Title</option>
    </select><br />
    Search Value: <input type="text" name="searchValue" required /><br />
    <input type="submit" name="command" value="searchBookCatalog" />
</form>
</body>
</html>