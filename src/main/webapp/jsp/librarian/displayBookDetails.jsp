<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display and Edit Book Details</title>
</head>
<body>
<h1>Book Details</h1>
<form name="updateBookData" action="controller" method="post">
    <%
        org.rsreu.library.model.BookCatalog book = (org.rsreu.library.model.BookCatalog) request.getAttribute("book");
    %>
    Title: <input type="text" name="title" value="<%= book.getTitle() %>" required /><br />
    Year Published: <input type="number" name="yearPublished" value="<%= book.getYearPublished() %>" required /><br />
    Author Name: <input type="text" name="authorName" value="<%= book.getAuthorName() %>" required /><br />
    Genre Name: <input type="text" name="genreName" value="<%= book.getGenreName() %>" required /><br />
    Publisher Name: <input type="text" name="publisherName" value="<%= book.getPublisherName() %>" required /><br />
    <input type="hidden" name="bookId" value="<%= book.getBookId() %>" />
    <input type="submit" name="command" value="updateBookData" />
</form>
</body>
</html>
