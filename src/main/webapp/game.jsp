<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome To Game</title>
    <script src="lib/angular.min.js"></script>
    <script src="lib/angular-route.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/controllers.js"></script>
    <link rel="stylesheet" href="css/game.css">
</head>
<body ng-app="gameApp" ng-controller="MainCtrl">
${hello}
<table class="controls perspective">
    <tr><td> </td><td class="up" ng-click="setAction('up')">▲</td><td> </td></tr>
    <tr><td class="left" ng-click="setAction('left')">◀</td><td> </td><td class="right" ng-click="setAction('right')">▶</td></tr>
    <tr><td> </td><td class="down" ng-click="setAction('down')">▼</td><td> </td></tr>
</table>
<table class="perspective">
    <tr ng-repeat="land_row in land.land track by $index">
        <td ng-repeat="land_td in land_row track by $index" class="cube">
            <div class="{{land_td.replace('characters.','')}}"></div>
        </td>
    </tr>
</table>
</body>
</html>