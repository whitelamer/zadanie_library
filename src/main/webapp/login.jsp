<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link href="<c:url value='/res/css/bootstrap.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/res/css/main.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body>
Приветствую вас в нашей библиотеке
<form method="POST" action="login">
    <c:if test="${not empty param.error}">
        <div class="error">
            Your login attempt was not successful, try again.<br />
            Reason: ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
    </c:if>

    <c:if test="${not empty param.logout}">
        <div class="alert alert-success">
            <p>You have been logged out successfully.</p>
        </div>
    </c:if>
    <table>
        <tr>
            <td align="right">Логин</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td align="right">Пароль</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td align="right">Запомнить</td>
            <td><input type="checkbox" name="_spring_security_remember_me" /></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Войти" />
                <input type="reset" value="Сброс" /></td>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
    </table>
</form>
</body>
</html>