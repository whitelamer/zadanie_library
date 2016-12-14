libraryApp.controller('MainCtrl', [ '$rootScope', '$scope', '$routeParams','$http', function( $rootScope, $scope,$routeParams,$http )
{
    $scope.userDetailsFn = function() {
        $http.get('userDetails').success(function(userDetails){
            $scope.userDetails = userDetails;
        });
    };
    $scope.userDetailsFn();
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