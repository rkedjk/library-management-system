<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert New Penalty</title>
</head>
<body>
<h1>Insert New Penalty</h1>
<form name="insertPenaltyForm" action="controller" method="post">
    Reader ID: <input type="text" name="readerId" required /><br />
    Validity: <input type="text" name="validity" required /><br />
    Reason: <input type="text" name="reason" required /><br />
    Penalty Date: <input type="date" name="penaltyDate" required /><br />
    Expiration Date: <input type="date" name="expirationDate" required /><br />
    Librarian ID: <input type="text" name="librarianId" required /><br />
    <input type="submit" name="command" value="insertPenalty" />
</form>
</body>
</html>
