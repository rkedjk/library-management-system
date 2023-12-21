<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Reservation</title>
</head>
<body>
<h1>Create Reservation</h1>
<form name="createreservation" action="controller" method="post"> <!-- Assuming 'reservation' is mapped to ReservationCommand -->
    <label for="inventoryId">Inventory ID:</label>
    <input type="text" id="inventoryId" name="inventoryId"><br><br>

    <!-- You can add more input fields as needed for other details -->

    <input type="submit" name="command" value="ReservationCommand">
</form>
</body>
</html>
