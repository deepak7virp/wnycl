'use strict';

angular.module('myApp').factory('PlayerService', ['$http', '$q', function($http, $q){

	var REST_SERVICE_URI = '/wnycl/players/';

    var factory = {
        fetchAllPlayers: fetchAllPlayers,
        createPlayer: createPlayer,
        updatePlayer:updatePlayer,
        deletePlayer:deletePlayer
    };

    return factory;

    function fetchAllPlayers(team) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, team)
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

    function createPlayer(player) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, player)
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


    function updatePlayer(player, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, player)
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

    function deletePlayer(id) {
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
