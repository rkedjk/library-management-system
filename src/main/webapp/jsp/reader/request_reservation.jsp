<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Book Reservation Request</title>
</head>
<body>
<h1>Book Reservation Request</h1>

<!-- Content for requesting book reservations goes here -->

<!-- For instance, a form to request book reservations -->
<form action="request_reservation.jsp" method="post">
    <!-- Placeholder form fields for requesting book reservations -->
    <label for="readerId">Reader ID:</label>
    <input type="text" id="readerId" name="readerId" required><br><br>

    <label for="bookId">Book ID:</label>
    <input type="text" id="bookId" name="bookId" required><br><br>

    <label for="reservationDate">Reservation Date:</label>
    <input type="date" id="reservationDate" name="reservationDate" required><br><br>

    <input type="submit" value="Request Reservation">
</form>

<!-- Placeholder data for previously reserved books -->
<h2>Previously Reserved Books:</h2>
<table border="1">
    <thead>
    <tr>
        <th>Reservation ID</th>
        <th>Reader ID</th>
        <th>Book ID</th>
        <th>Reservation Date</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>101</td>
        <td>201</td>
        <td>2023-11-25</td>
    </tr>
    <!-- Add more rows with placeholder data as needed -->
    </tbody>
</table>

</body>
</html>
