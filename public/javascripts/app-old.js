angular.module("getbookmarks.services", ["ngResource"]).
    factory('Story', function ($resource) {
        var Story = $resource('/offices/:officeId', {storyId: '@id'});
        Story.prototype.isNew = function(){
            return (typeof(this.id) === 'undefined');
        }
        return Story;
    });

angular.module("getbookmarks", ["getbookmarks.services"]).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {templateUrl: '/assets/views/stories/list.html', controller: StoryListController})
            .when('/stories/:storyId', {templateUrl: '/assets/views/stories/detail.html', controller: StoryDetailController});
    }]);

function StoryListController($scope, Story) {
    $scope.stories = Story.query();
    
}




function StoryDetailController($scope, $routeParams, $location, Story) {
    var storyId = $routeParams.storyId;
    
    $scope.story = Story.get({storyId: storyId});

}
