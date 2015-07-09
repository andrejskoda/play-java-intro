angular.module("getbookmarks.services", ["ngResource"]).
    factory('Story', function ($resource) {
        var Story = $resource('/api/offices/:officeId', {storyId: '@id'});
        Story.prototype.isNew = function(){
            return (typeof(this.id) === 'undefined');
        }
        return Story;
    }).controller('StoryListController', ['$scope','Story',function($scope, Story) {
        $scope.stories = Story.query(function(){
            console.log('all stories - ', $scope.stories.length);
        });
        $scope.sort = function(){
            $scope.sort.order = !$scope.sort.order;
        };

        /* default values */
        $scope.sort.order = false;
    }]);

angular.module("getbookmarks", ['ngRoute','getbookmarks.services']).
    config(['$routeProvider',function ($routeProvider) {
        $routeProvider
            .when('/', {templateUrl: '/assets/views/stories/list.html', controller: 'StoryListController'})
            .when('/stories/:storyId', {templateUrl: '/assets/views/stories/detail.html', controller: StoryDetailController});
    }]);






function StoryDetailController($scope, $routeParams, $location, Story) {
    var storyId = $routeParams.storyId;

    $scope.story = Story.get({storyId: storyId});

}
