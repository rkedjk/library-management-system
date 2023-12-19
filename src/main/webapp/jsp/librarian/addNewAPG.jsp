<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Data</title>
</head>
<body>
<h1>Insert Data</h1>

<h2>Insert Author</h2>
<form name="insertAuthorForm" action="controller" method="post">
    Author Name: <input type="text" name="authorName" required /><br />
    <button type="submit" name="action" value="insertAuthor"></button>
    <input type="hidden" name="command" value="addnewapgcommand"/>
</form>

<h2>Insert Genre</h2>
<form name="insertGenreForm" action="controller" method="post">
    Genre Name: <input type="text" name="genreName" required /><br />
    <button type="submit" name="action" value="insertGenre"></button>
    <input type="hidden" name="command" value="addnewapgcommand"/>
</form>

<h2>Insert Publisher</h2>
<form name="insertPublisherForm" action="controller" method="post">
    Publisher Name: <input type="text" name="publisherName" required  /><br />
    <button type="submit" name="action" value="insertPublisher"></button>
    <input type="hidden" name="command" value="addnewapgcommand"/>
</form>
</body>
</html>
