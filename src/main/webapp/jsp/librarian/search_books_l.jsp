<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Books</title>
</head>
<body>
<h1>Search Books</h1>

<!-- Search form -->
<div class="search-container">
    <!-- Form for searching books -->
    <div class="search-form">
        <h2>Search by Title, Author, or Genre</h2>
        <form action="search_books_l.jsp" method="get">
            <!-- Form fields for searching books -->
            <label for="searchTitle">Search by Title, Author, or Genre:</label>
            <input type="text" id="searchTitle" name="searchTitle"><br><br>

            <input type="submit" value="Search">
        </form>
    </div>

    <!-- Type of search form -->
    <div class="search-type-form">
        <h2>Choose Type of Search</h2>
        <form action="search_type_books.jsp" method="get">
            <!-- Form fields for choosing type of search -->
            <label for="searchType">Select Search Type:</label>
            <select id="searchType" name="searchType">
                <option value="title">Title</option>
                <option value="author">Author</option>
                <option value="genre">Genre</option>
            </select><br><br>

            <input type="submit" value="Search">
        </form>
    </div>
</div>
<!-- Placeholder data to demonstrate search results -->
<h2>Search Results:</h2>
<table border="1">
    <thead>
    <tr>
        <th>Book ID</th>
        <th>Title</th>
        <th>Year Published</th>
        <th>Author ID</th>
        <th>Genre ID</th>
        <th>Publisher ID</th>
    </tr>
    </thead>
    <tbody>
    <!-- Placeholder search results -->
    <tr>
        <td>101</td>
        <td>Book Title 1</td>
        <td>2005</td>
        <td>201</td>
        <td>301</td>
        <td>401</td>
    </tr>
    <tr>
        <td>102</td>
        <td>Book Title 2</td>
        <td>2010</td>
        <td>202</td>
        <td>302</td>
        <td>402</td>
    </tr>
    <!-- Add more rows with placeholder search results as needed -->
    </tbody>
</table>

</body>
</html>
