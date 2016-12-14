<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
Приветствую вас <strong>${user}</strong> в нашей библиотеке
<a href='<c:url value="/logout"/>' >Logout</a>
</body>
</html>