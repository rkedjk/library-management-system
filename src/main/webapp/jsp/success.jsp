<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@ include file="header.jsp" %>
<head>
    <title>Success Page</title>
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <style>

        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
            color: #333;
        }
        .success-container {
            max-width: 600px;
            padding: 40px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            font-size: 2.5em;
            margin-bottom: 20px;
            color: #27ae60;
        }
        p {
            font-size: 1.2em;
            line-height: 1.6;
        }
    </style>
</head>
<body>
<div class="success-container">
    <h1>Success!</h1>
    <p>Your action was completed successfully.</p>

</div>

<%@ include file="footer.jsp" %>

</body>
</html>
