<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Search</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
<h2>User Search</h2>
<form name ="searchusers" action="controller" method="post">
    <input type="hidden" name="command" value="searchusers">
    <label for="searchType">Type of Search:</label>
    <select name="searchType" id="searchType">
        <option value="id">ID</option>
        <option value="type">Type</option>
        <option value="status">Status</option>
        <option value="typeAndStatus">Type and Status</option>
    </select>
    <br><br>

    <div id="typeDropdown" style="display:none;">
        <label for="userType">User Type:</label>
        <select name="userType" id="userType">
            <option value="LIBRARIAN">Librarian</option>
            <option value="READER">Reader</option>
            <option value="ADMIN">Admin</option>
        </select>
        <br><br>
    </div>

    <div id="statusDropdown" style="display:none;">
        <label for="userStatus">User Status:</label>
        <select name="userStatus" id="userStatus">
            <option value="ACTIVE">Active</option>
            <option value="SUSPENDED">Suspended</option>
        </select>
        <br><br>
    </div>

    <input type="text" name="searchValue" id="searchValue">
    <br><br>

    <button type="submit" name="action" id="viewUserListBtn" value="Search" class="btn btn-success">View</button><br>
</form>

<script>
    const searchTypeSelect = document.getElementById('searchType');
    const typeDropdown = document.getElementById('typeDropdown');
    const statusDropdown = document.getElementById('statusDropdown');
    const searchValueInput = document.getElementById('searchValue');

    searchTypeSelect.addEventListener('change', function() {
        const selectedOption = this.value;
        switch(selectedOption) {
            case 'type':
                typeDropdown.style.display = 'block';
                statusDropdown.style.display = 'none';
                searchValueInput.style.display = 'none';
                break;
            case 'status':
                typeDropdown.style.display = 'none';
                statusDropdown.style.display = 'block';
                searchValueInput.style.display = 'none';
                break;
            case 'typeAndStatus':
                typeDropdown.style.display = 'block';
                statusDropdown.style.display = 'block';
                searchValueInput.style.display = 'none';
                break;
            case 'id':
            default:
                typeDropdown.style.display = 'none';
                statusDropdown.style.display = 'none';
                searchValueInput.style.display = 'block';
                break;
        }
    });
</script>
</body>
</html>
