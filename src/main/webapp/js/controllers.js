gameApp.controller('MainCtrl', [ '$rootScope', '$scope', '$routeParams','$http', function( $rootScope, $scope,$routeParams,$http )
{
    $scope.fetchSettleMap = function() {
        $http.get('gameland').success(function(settleMap){
            $scope.land = settleMap;
            for(var i=0;i<$scope.land.land.length;i++){
                for(var j=0;j<$scope.land.land[i].length;j++){
                    if($scope.land.land[i][j].length==0)$scope.land.land[i][j]="empty";
                }
            }
        });
    };
    $scope.setAction = function(action){
        console.log("setAction:"+action);
        $http.get('gameplayer/'+action).success(function(){
            $scope.fetchSettleMap();
        });
    };
    $scope.fetchSettleMap();
}]);