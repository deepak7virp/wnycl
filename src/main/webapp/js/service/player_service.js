'use strict';

angular.module('myApp').service('PlayerService', ['$http', '$q','$routeParams', function($http, $q,$routeParams){

	var REST_SERVICE_URI = '/wnycl/player/';
	
    var factory = {
    	findPlayersByTeam: findPlayersByTeam,
        createPlayer: createPlayer,
    };
    return factory;
	findPlayersByTeam($routeParams.teamid);
	
    function findPlayersByTeam(teamid) {	    	
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+teamid)
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

    function createPlayer(team) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, team)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Player');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
