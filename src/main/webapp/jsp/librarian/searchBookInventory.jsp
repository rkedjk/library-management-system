<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Book Catalog</title>
</head>
<body>
<h1>Search Book Catalog</h1>
<form name="searchBookInventoryCommand" action="controller" method="post">
    Search Type:
    <select name="searchType">
        <option value="inventory_id">Inventory ID</option>
        <option value="status">Status</option>
        <option value="book_id">Book ID</option>
    </select><br />
    Search Value: <input type="text" name="searchValue" required /><br />
    <input type="submit" name="command" value="searchBookInventoryCommand" />
</form>
</body>
</html>
