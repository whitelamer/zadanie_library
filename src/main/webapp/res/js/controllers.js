libraryApp.controller('MainCtrl', [ '$rootScope', '$scope','$route', '$routeParams','$http','$location', function( $rootScope, $scope,$route,$routeParams,$http ,$location)
{
    $scope.userDetailsFn = function() {
        $http.get('userDetails').success(function(userDetails){
            $scope.userDetails = userDetails;
        });
    };
    $scope.userDetailsFn();
    $scope.$route = $route;
    $scope.$location =$location;
    $scope.$routeParams = $routeParams;
}]);

libraryApp.controller('UsersCtrl', [ '$rootScope', '$scope', '$routeParams','$http', function( $rootScope, $scope,$routeParams,$http )
{
    $scope.loadUserList = function() {
        $http.get('userList').success(function(userDetails){
            $scope.userList = userList;

        });
    };
    $scope.loadUserList();
}]);