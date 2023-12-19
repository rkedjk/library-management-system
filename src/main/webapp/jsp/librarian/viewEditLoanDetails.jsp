<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>View and Edit Loan Details</title>
</head>
<body>
<h1>Loan Details</h1>
<form name="updateLoanData" action="controller" method="post">
    <%
        org.rsreu.library.model.Loan loan = (org.rsreu.library.model.Loan) request.getAttribute("loan");
    %>
    <!-- Display loan details here and provide fields for editing -->
    <!-- For example (adjust the fields according to your loan object) -->
    Loan ID: <%= loan.getLoanId() %><br />
    Inventory ID: <input type="text" name="inventoryId" value="<%= loan.getInventoryId() %>" required /><br />
    Reader ID: <input type="text" name="readerId" value="<%= loan.getReaderId() %>" required /><br />
    Loan Date: <input type="text" name="loanDate" value="<%= loan.getLoanDate() %>" required /><br />
    Due Date: <input type="text" name="dueDate" value="<%= loan.getDueDate() %>" required /><br />
    Status: <input type="text" name="status" value="<%= loan.getStatus() %>" required /><br />
    Return Date: <input type="text" name="returnDate" value="<%= loan.getReturnDate() %>" /><br />
    <input type="hidden" name="loanId" value="<%= loan.getLoanId() %>" />
    <input type="submit" name="command" value="updateLoanData" />
</form>
</body>
</html>
