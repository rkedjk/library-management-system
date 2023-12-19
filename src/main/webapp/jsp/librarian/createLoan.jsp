<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Loan</title>
</head>
<body>
<h1>Create New Loan</h1>
<form name="createLoanForm" action="controller" method="post">
    Inventory ID: <input type="text" name="inventoryId" required /><br />
    Reader ID: <input type="text" name="readerId" required /><br />
    Loan Date: <input type="date" name="loanDate" required /><br />
    Due Date: <input type="date" name="dueDate" required /><br />
    Status: <input type="text" name="status" required /><br />
    <input type="submit" name="command" value="createLoan" />
</form>
</body>
</html>
