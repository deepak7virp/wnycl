'use strict';

angular.module('myApp').factory('TourService', ['$http', '$q', function($http, $q){

	
	var GET_ALL_TOURS_URI = '/wnycl/allTours/';
	var GET_TOUR_URI = '/wnycl/tour/';	//add id at end
	var POST_CREATE_TOUR_URI = '/wnycl/createTour/';
	var PUT_UPDATE_TOUR_URI = '/wnycl/updateTour/'; //add id at end
	var DELETE_TOUR_URI = '/wnycl/deleteTour/';	//add id at end
	var DELETE_ALL_TOURS_URI = '/wnycl/deleteAllTours/';
	

    var factory = {
        fetchAllTours: fetchAllTours,
        createTour: createTour,
        updateTour:updateTour,
        deleteTour:deleteTour
    };
   
    return factory;

    
    function fetchAllTours() {
        var deferred = $q.defer();
        $http.get(GET_ALL_TOURS_URI)
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

    function createTour(tour) {
        var deferred = $q.defer();
        $http.post(POST_CREATE_TOUR_URI, tour)
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


    function updateTour(tour, id) {
        var deferred = $q.defer();
        $http.put(PUT_UPDATE_TOUR_URI+id, tour)
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

    function deleteTour(id) {
        var deferred = $q.defer();
        $http.del(DELETE_TOUR_URI+id)
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
