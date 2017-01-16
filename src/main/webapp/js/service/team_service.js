'use strict';

angular.module('myApp').factory('TeamService', ['$http', '$q', function($http, $q){

	var REST_SERVICE_URI = '/wnycl/team/';

    var factory = {
        fetchAllTeams: fetchAllTeams,
        createTeam: createTeam,
        updateTeam:updateTeam,
        deleteTeam:deleteTeam
    };

    return factory;

    function fetchAllTeams() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Teams');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createTeam(team) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, team)
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
        $http.put(REST_SERVICE_URI+id, team)
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
        $http.delete(REST_SERVICE_URI+id)
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
