'use strict';

angular.module('myApp.offices', ['ngRoute','ngResource','myApp','ngMap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider
      .when('/offices', {
        templateUrl: 'assets/offices/list.html',
        controller: 'ListCtrl'
    })
      .when('/offices/:id',{
        templateUrl: 'assets/offices/single.html',
        controller: 'SingleCtrl'
    });
}])

.controller('ListCtrl', ['$scope','Office','$location',function($scope, Office, $location) {

    $scope.offices = Office.query(function(){
        console.log('all categories - ', $scope.offices.length);
    });
    $scope.sort = function(){
        $scope.sort.order = !$scope.sort.order;
    };

    /* default values */
    $scope.sort.order = false;
    $scope.sort.field = 'DisPlz';
    $scope.show = function (id) {
        $location.url('/offices/' + id);
    };
}])
.controller('SingleCtrl', ['$scope','Office','$routeParams',function ($scope, Office, $routeParams) {
    $scope.office = Office.get({ id: $routeParams.id });
}]);