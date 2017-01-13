'use strict';
 
angular.module('myApp').factory('TeamService', ['$http', '$q', function($http, $q){
 
	var REST_ALL_TEAMS_URI = '/wnycl/teams/' 
    var REST_TEAM_URI = '/wnycl/team/';
 
    var factory = {
        getAllTeams: getAllTeams,
        createTeam: createTeam,
        updateTeam:updateTeam,
        deleteTeam:deleteTeam
    };
 
    return factory;
 
    function getAllTeams() {
        var deferred = $q.defer();
        $http.get(REST_ALL_TEAMS_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while getting Teams');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createTeam(team) {
        var deferred = $q.defer();
        $http.post(REST_TEAM_URI, team)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Team');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateTeam(team, id) {
        var deferred = $q.defer();
        $http.put(REST_TEAM_URI+id, team)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Team');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteTeam(id) {
        var deferred = $q.defer();
        $http.del(REST_TEAM_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Team');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);
 