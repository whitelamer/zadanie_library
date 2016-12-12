<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
Приветствую вас в нашей библиотеке
<form method="POST" action="<c:url value="/j_spring_security_check" />">
    <table>
        <tr>
            <td align="right">пожалуйста введите имя учетной записи либо номер читательского билета</td>
            <td><input type="text" name="j_username" /></td>
        </tr>
        <tr>
            <td align="right">Также укажите ваш пароль</td>
            <td><input type="password" name="j_password" /></td>
        </tr>
        <tr>
            <td align="right">Запомнить</td>
            <td><input type="checkbox" name="_spring_security_remember_me" /></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Login" />
                <input type="reset" value="Reset" /></td>
        </tr>
    </table>
</form>
</body>
</html>