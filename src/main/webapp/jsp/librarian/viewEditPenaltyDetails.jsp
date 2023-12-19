<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>View and Edit Penalty Details</title>
</head>
<body>
<h1>Penalty Details</h1>
<form name="updatePenaltyData" action="controller" method="post">
    <%
        org.rsreu.library.model.Penalty penalty = (org.rsreu.library.model.Penalty) request.getAttribute("penalty");
    %>
    <!-- Display penalty details here and provide fields for editing -->
    <!-- For example (adjust the fields according to your penalty object) -->
    Penalty ID: <%= penalty.getPenaltyId() %><br />
    Reader ID: <input type="text" name="readerId" value="<%= penalty.getReaderId() %>" required /><br />
    Validity: <input type="text" name="validity" value="<%= penalty.getValidity() %>" required /><br />
    Reason: <input type="text" name="reason" value="<%= penalty.getReason() %>" required /><br />
    Penalty Date: <input type="text" name="penaltyDate" value="<%= penalty.getPenaltyDate() %>" required /><br />
    Expiration Date: <input type="text" name="expirationDate" value="<%= penalty.getExpirationDate() %>" required /><br />
    Librarian ID: <input type="text" name="librarianId" value="<%= penalty.getLibrarianId() %>" required /><br />
    <input type="hidden" name="penaltyId" value="<%= penalty.getPenaltyId() %>" />
    <input type="submit" name="command" value="updatePenaltyData" />
</form>
</body>
</html>
