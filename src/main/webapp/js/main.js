var gameApp = angular.module('gameApp', ['ngRoute']);

gameApp.config(['$routeProvider', '$httpProvider', '$locationProvider', function ($routeProvider, $httpProvider, $locationProvider) {

    $locationProvider.html5Mode({enabled: true,requireBase: false});

    $routeProvider.
    when('/game', {
            templateUrl: 'game.html',
            controller: 'MainCtrl'
            }).
    otherwise({redirectTo: '/'});

    $httpProvider.defaults.useXDomain = true;
    $httpProvider.defaults.withCredentials = true;

    delete $httpProvider.defaults.headers.common["X-Requested-With"];
    $httpProvider.defaults.headers.common["Accept"] = "application/json";
    $httpProvider.defaults.headers.common["Content-Type"] = "application/json";
    }]);
