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
    when('/users/add', {
        templateUrl: '/res/templ/editUser.html',
        controller: 'UsersAddCtrl'
    }).
    when('/users/edit/:userId', {
        templateUrl: '/res/templ/editUser.html',
        controller: 'UsersEditCtrl'
    }).
    when('/books/list', {
        templateUrl: '/res/templ/books.html',
        controller: 'BooksCtrl'
    }).
    when('/books/add', {
        templateUrl: '/res/templ/editBook.html',
        controller: 'BooksAddCtrl'
    }).
    when('/books/edit/:bookId', {
        templateUrl: '/res/templ/editBook.html',
        controller: 'BooksEditCtrl'
    }).
    when('/books/take/:bookId', {
        templateUrl: '/res/templ/books.html',
        controller: 'BooksTakeCtrl'
    }).
    otherwise({templateUrl: '/res/templ/index.html',controller: 'MainCtrl'});

    // $httpProvider.defaults.useXDomain = true;
    // $httpProvider.defaults.withCredentials = true;
    //
    // delete $httpProvider.defaults.headers.common["X-Requested-With"];
    // $httpProvider.defaults.headers.common["Accept"] = "application/json";
    // $httpProvider.defaults.headers.common["Content-Type"] = "application/json";
    }]);
