<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
Приветствую вас в нашей библиотеке
<form method="POST" action="login">
    <c:if test="${param.error != null}">
        <div class="alert alert-danger">
            <p>Invalid username and password.</p>
        </div>
    </c:if>
    <c:if test="${param.logout != null}">
        <div class="alert alert-success">
            <p>You have been logged out successfully.</p>
        </div>
    </c:if>
    <table>
        <tr>
            <td align="right">пожалуйста введите имя учетной записи либо номер читательского билета</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td align="right">Также укажите ваш пароль</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td align="right">Запомнить</td>
            <td><input type="checkbox" name="_spring_security_remember_me" /></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Login" />
                <input type="reset" value="Reset" /></td>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
    </table>
</form>
</body>
</html>