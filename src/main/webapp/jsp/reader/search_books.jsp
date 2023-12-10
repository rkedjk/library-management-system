<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Books</title>
</head>
<body>
<h2>Search Books</h2>
<form name="searchForm" method="GET" action="searchController">
    Search by:
    <select name="searchType">
        <option value="name">Name</option>
        <option value="author">Author</option>
        <option value="genre">Genre</option>
    </select>
    <br/><br/>
    Search Term:
    <input type="text" name="searchTerm" value=""/>
    <br/><br/>
    <input type="submit" value="Search"/>
</form>

<hr/>

<h2>Search Results</h2>
<!-- Placeholder for displaying the table of books -->
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Author</th>
        <th>Genre</th>
        <!-- Add more columns as needed -->
    </tr>
    </thead>
    <tbody>
    <!-- Display book data dynamically here -->
    <tr>
        <td>Book 1 Name</td>
        <td>Author 1</td>
        <td>Genre 1</td>
        <!-- Add more rows based on search results -->
    </tr>
    <tr>
        <td>Book 2 Name</td>
        <td>Author 2</td>
        <td>Genre 2</td>
        <!-- Add more rows based on search results -->
    </tr>
    <!-- Add more rows based on search results -->
    </tbody>
</table>
</body>
</html>
