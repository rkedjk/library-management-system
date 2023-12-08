<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h3 {
            text-align: center;
            color: #333;
        }

        hr {
            width: 50%;
            margin: 20px auto;
            border-color: #ccc;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #4caf50;
            transition: color 0.3s ease;
        }

        a:hover {
            color: #45a049;
        }
    </style>
</head>
<body>
<h3>Welcome</h3>
<hr/>
${user}, hello!
<hr/>
<a href="controller?command=logout">Logout</a>
</body>
</html>
