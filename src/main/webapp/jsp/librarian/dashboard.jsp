<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Librarian Dashboard</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="librarian/style.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<style>
    /* Three-column layout */
    .container {
        display: flex;
        justify-content: space-between;
    }
    .management-section {
        width: 30%;
        margin: 10px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
</style>
<div class="container">
    <h2>Librarian Dashboard</h2>

    <!-- Book Inventory Management -->
    <div class="management-section">
        <h3>Book Inventory Management</h3>
        <form name="addNewCopyForm" method="post" action="controller">
            <!-- Add new copy -->
            <input type="hidden" name="command" value="librariandashboard"/>

            <button type="submit" name="action" value="add_new_copy">Add New Copy</button><br>
        </form>

        <form name="searchCopyForm" method="post" action="controller">
            <!-- Search Copy -->
            <input type="hidden" name="command" value="librariandashboard"/>
            <button type="submit" name="action" value="search_copy">Search Copy</button><br>
        </form>

        <form name="updateCopyDataForm" method="post" action="controller">
            <!-- Update copy data -->
            <input type="hidden" name="command" value="librariandashboard"/>
            <button type="submit" name="action" value="update_copy_data">Update Copy Data</button><br>
        </form>

        <form name="changeCopyStatusForm" method="post" action="controller">
            <!-- Change Copy status -->
            <input type="hidden" name="command" value="librariandashboard"/>
            <button type="submit" name="action" value="change_copy_status">Change Copy Status</button><br>
        </form>

    </div>

    <!-- Book Catalog Management -->
    <div class="management-section">
        <h3>Book Catalog Management</h3>
        <form name="addNewBookForm" method="post" action="controller">
            <!-- Add new book -->
            <input type="hidden" name="command" value="librariandashboard"/>
            <button type="submit" name="action" value="add_new_book">Add New Book</button><br>
        </form>

        <form name="searchBookForm" method="post" action="controller">
            <!-- Search Book -->
            <input type="hidden" name="command" value="librariandashboard"/>
            <button type="submit" name="action" value="search_book">Search Book</button><br>
        </form>


        <form name="addNewAPGForm" method="post" action="controller">
            <!-- Add new Author/Publisher/Genre -->
            <input type="hidden" name="command" value="librariandashboard"/>
            <button type="submit" name="action" value="add_new_apg">Add New Author/Publisher/Genre</button><br>
        </form>

    </div>

    <!-- Reader Management -->
    <div class="management-section">
        <h3>Reader Management</h3>
        <form name="addNewLoanForm" method="post" action="controller">
            <input type="hidden" name="command" value="librariandashboard"/>
            <!-- Add new Loan -->
            <button type="submit" name="action" value="add_new_loan">Add New Loan</button><br>
        </form>

        <form name="updateLoanDataForm" method="post" action="controller">
            <input type="hidden" name="command" value="librariandashboard"/>
            <!-- Update Loan data -->
            <button type="submit" name="action" value="update_loan_data">Update Loan Data</button><br>
        </form>

        <form name="addNewPenaltyForm" method="post" action="controller">
            <input type="hidden" name="command" value="librariandashboard"/>
            <!-- Add new penalty -->
            <button type="submit" name="action" value="add_new_penalty">Add New Penalty</button><br>
        </form>

        <form name="updatePenaltyDataForm" method="post" action="controller">
            <!-- Update penalty Data -->
            <input type="hidden" name="command" value="librariandashboard"/>
            <button type="submit" name="action" value="update_penalty_data">Update Penalty Data</button><br>
        </form>

        <form name="searchReadersLoansForm" method="post" action="controller">
            <!-- Search reader's loans -->
            <input type="hidden" name="command" value="librariandashboard"/>
            <button type="submit" name="action" value="search_readers_loans">Search Reader's Loans</button><br>
        </form>

        <form name="searchReadersPenaltiesForm" method="post" action="controller">
            <!-- Search reader's penalties -->
            <input type="hidden" name="command" value="librariandashboard"/>
            <button type="submit" name="action" value="search_readers_penalties">Search Reader's Penalties</button><br>
        </form>
    </div>

    <button onclick="goBack()">Return to Previous Page</button>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>
