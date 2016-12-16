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
        $http.get('userList').success(function(data){
            $rootScope.userList = data;
        });
    };
    $scope.loadUserList();
}]);

libraryApp.controller('UsersEditCtrl', [ '$rootScope', '$scope', '$routeParams','$http', function( $rootScope, $scope,$routeParams,$http )
{
    for(var i=0;i<$rootScope.userList.length;i++)
        if($routeParams.userId==$rootScope.userList[i].id)$scope.editUser=$rootScope.userList[i];
    $scope.saveUser = function() {
        $http.post('userEdit',
            $scope.editUser
        ).
        success(function(data, status, headers) {
            alert("User edited added");
            var newTaskUri = headers()["location"];
            console.log("Might be good to GET " + newTaskUri + " and append the task.");
        });
    }
}]);

libraryApp.controller('UsersAddCtrl', [ '$rootScope', '$scope','$http', function( $rootScope, $scope,$http )
{
    $scope.editUser={
        firstname:"",
        lastname:"",
        email:"",
        password:""
    }
    $scope.saveUser = function() {
        $http.post('userAdd',
            $scope.editUser
        ).
        success(function(data, status, headers) {
            alert("User edited added");
            var newTaskUri = headers()["location"];
            console.log("Might be good to GET " + newTaskUri + " and append the task.");
        });
    }
}]);