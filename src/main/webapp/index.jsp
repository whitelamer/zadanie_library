<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome To Library</title>
    <link href="<c:url value='/res/css/bootstrap.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/res/css/main.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
<c:choose>
<c:when test="${not empty user}">
        <script src="res/lib/angular.min.js"></script>
        <script src="res/lib/angular-route.min.js"></script>
        <script src="res/js/main.js"></script>
        <script src="res/js/controllers.js"></script>
    </head>
        <body ng-app="libraryApp" ng-controller="MainCtrl">
        Приветствую вас <strong>${user}</strong> в нашей библиотеке
        <a href="/logout" >Logout</a>
        <table ng-if="(userDetails||null)!=null" class="table-bordered">
            <tr><td class="col-md-6 text-right">Имя:</td><td class="col-md-6 text-xs-right">{{userDetails.firstname}}</td></tr>
            <tr><td class="col-md-6 text-right">Фамилия:</td><td class="col-md-6 text-xs-right">{{userDetails.lastname}}</td></tr>
            <tr ng-repeat="userPassport in userDetails.userPassports">
                <td colspan="2"><table>
                    <tr><td>Читательский Билет номер:</td><td>{{userPassport.id}}</td></tr>
                    <tr><td>Статус:</td><td>{{userPassport.state}}</td></tr>
                    <tr><td>Книг взято:</td><td>0</td></tr>
                    <tr><td>Книг просроченно:</td><td>0</td></tr>
                </table>
                </td>
            </tr>
        </table>

        <div class="tools pull-left">
            <a href="#!users" class="btn btn-success">Список читателей</a>
        </div>

        <div class="btn btn-default" ng-click="findBookList()">Поиск книги</div>
        <div class="btn btn-default" ng-click="showBookList()">Список книг</div>
        <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
            <br>User ${user} in ADMIN Group<br>
            <div class="btn btn-default" ng-click="showUserList()">Список читателей</div>
            <div class="btn btn-default" ng-click="findUser">Поиск читателя</div>
        </c:if>
        <ng-view></ng-view>
        </body>
    </c:when>
    <c:otherwise>
        </head>
        <body>
        Приветствую вас в нашей библиотеке<br>для полного доступа вам необходимо <a href="/login">войти</a>
        </body>
    </c:otherwise>
</c:choose>
</html>