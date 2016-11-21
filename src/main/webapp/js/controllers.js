gameApp.controller('MainCtrl', [ '$rootScope', '$scope', '$routeParams','$http', function( $rootScope, $scope,$routeParams,$http )
{
    $scope.fetchSettleMap = function() {
        $http.get('gameland').success(function(settleMap){
            $scope.land = settleMap;
        });
    };
    $scope.fetchSettleMap();
}]);