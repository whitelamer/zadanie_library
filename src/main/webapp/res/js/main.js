var libraryApp = angular.module('libraryApp', ['ngRoute']);

libraryApp.config(['$routeProvider', function ($routeProvider) {

    // $locationProvider.html5Mode({enabled: true,requireBase: false});
    // when('', {
    //     templateURL: "/res/templ/index.html",
    //     controller: 'MainCtrl'
    // }).

    $routeProvider.
    when('/users/list', {
        templateUrl: '/res/templ/users.html',
        controller: 'UsersCtrl'
    }).
    otherwise({templateUrl: '/res/templ/index.html',controller: 'MainCtrl'});

    // $httpProvider.defaults.useXDomain = true;
    // $httpProvider.defaults.withCredentials = true;
    //
    // delete $httpProvider.defaults.headers.common["X-Requested-With"];
    // $httpProvider.defaults.headers.common["Accept"] = "application/json";
    // $httpProvider.defaults.headers.common["Content-Type"] = "application/json";
    }]);
