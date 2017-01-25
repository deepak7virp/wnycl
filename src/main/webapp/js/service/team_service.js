'use strict';

angular.module('myApp').factory('TeamService', ['$http', '$q', function($http, $q){

	
	var GET_ALL_TEAMS_URI = '/wnycl/allTeams/';
	var GET_TEAM_URI = '/wnycl/team/';	//add id at end
	var POST_CREATE_TEAM_URI = '/wnycl/createTeam/';
	var PUT_UPDATE_TEAM_URI = '/wnycl/updateTeam/'; //add id at end
	var DELETE_TEAM_URI = '/wnycl/deleteTeam/';	//add id at end
	var DELETE_ALL_TEAMS_URI = '/wnycl/deleteAllTeams/';
	var ASSIGN_CAPTAIN_URI = '/wnycl/assignTeamCaptain/';
	

    var factory = {
        fetchAllTeams: fetchAllTeams,
        createTeam: createTeam,
        updateTeam:updateTeam,
        deleteTeam:deleteTeam,
        assignCaptain : assignCaptain
    };
   
    return factory;

    function assignCaptain(teamid, playerid){
    	var deferred = $q.defer();
    	$http.get(ASSIGN_CAPTAIN_URI+teamid+"/"+playerid)
    		 .then(
    				 function(response){
    					 deferred.resolve(response.data);
    				 },
    				 function(errResponse){
    					 console.error('Error while Assigning Captain');
    					 deferred.reject(errResponse);
    				 }
    			);
    	return deferred.promise;
    }
    
    function fetchAllTeams() {
        var deferred = $q.defer();
        $http.get(GET_ALL_TEAMS_URI)
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
        $http.post(POST_CREATE_TEAM_URI, team)
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
        $http.put(PUT_UPDATE_TEAM_URI+id, team)
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
        $http.del(DELETE_TEAM_URI+id)
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
