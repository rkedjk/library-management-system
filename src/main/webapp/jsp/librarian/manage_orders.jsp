<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Book Orders</title>
</head>
<body>
<h1>Manage Book Orders</h1>

<!-- Placeholder data for displaying loan details -->
<h2>Loan Details:</h2>
<table border="1">
    <thead>
    <tr>
        <th>Loan ID</th>
        <th>Book ID</th>
        <th>Reader ID</th>
        <th>Loan Date</th>
        <th>Due Date</th>
        <th>Return Date</th>
        <th>Status</th>
        <th>Librarian ID</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>101</td>
        <td>201</td>
        <td>2023-11-15</td>
        <td>2023-12-15</td>
        <td></td>
        <td>Active</td>
        <td>301</td>
    </tr>
    <!-- Placeholder data for additional loans -->
    <!-- Add more rows with placeholder data as needed -->
    </tbody>
</table>

<!-- Form to manage book orders -->
<h2>Manage Orders:</h2>
<form action="manage_orders.jsp" method="post">
    <!-- Form fields to manage book orders -->
    <label for="loanId">Loan ID:</label>
    <input type="number" id="loanId" name="loanId" required><br><br>

    <label for="returnDate">Return Date:</label>
    <input type="date" id="returnDate" name="returnDate"><br><br>

    <input type="submit" value="Update Order">
</form>

</body>
</html>
