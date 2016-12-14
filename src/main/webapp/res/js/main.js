var libraryApp = angular.module('libraryApp', ['ngRoute']);

libraryApp.config(['$routeProvider', '$httpProvider', '$locationProvider', function ($routeProvider, $httpProvider, $locationProvider) {

    $locationProvider.html5Mode({enabled: true,requireBase: false});

    $routeProvider.
    when('/index', {
        templateURL: "/res/templ/index.html",
        controller: 'MainCtrl'
    }).
    when('#!users', {
        templateURL: "/res/templ/users.html",
        controller: 'UsersCtrl'
    }).
    otherwise({redirectTo: '/index'});

    $httpProvider.defaults.useXDomain = true;
    $httpProvider.defaults.withCredentials = true;

    delete $httpProvider.defaults.headers.common["X-Requested-With"];
    $httpProvider.defaults.headers.common["Accept"] = "application/json";
    $httpProvider.defaults.headers.common["Content-Type"] = "application/json";
    }]);
