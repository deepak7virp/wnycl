'use strict';

angular.module('myApp').controller('TourController', ['$scope', 'TourService', function($scope, TourService) {
    $scope.tour = {
    		tourid:'',
    		name:'',
    		venue:{
    			venueid : '',
    			name : '',
    			location : '',
    			incharge : '',
    			phone : ''
    		},
    		startdate : '',
    		enddate : '',
    		teamcount : '',
    		playercount : ''
    };
    $scope.row = {
    		glyphs : {
    			edit : true,
        		submit : false,
        		cancel : false
    		}
    
    }
    $scope.tours=[];
    $scope.addTourClicked = false;
    $scope.rows = {};
    
    $scope.edit = function(tour){
    	$scope.tour = JSON.parse(JSON.stringify(tour));
    	$scope.rows[tour.tourid].glyphs.edit = false;
        $scope.rows[tour.tourid].glyphs.submit = true;
        $scope.rows[tour.tourid].glyphs.cancel = true;
    }
    
    $scope.addClick = function(){
    	$scope.addTourClicked = true;
    	$scope.rows[tourid].glyphs.edit = true;
        $scope.rows[tourid].glyphs.submit = false;
        $scope.rows[tourid].glyphs.cancel = false;
    }
    
    $scope.fetchAllTours = function(){
        TourService.fetchAllTours()
            .then(
            function(d) {
            	if(d.length != 0){
            		$scope.tours = d;
                    $scope.tours.forEach(function(tour, index, array){
                    	$scope.rows[tour.tourid] = JSON.parse(JSON.stringify($scope.row));
                    });
            	}
            },
            function(errResponse){
                console.error('Error while fetching Tours');
            }
        );
    }
    
    $scope.fetchAllTours();

    $scope.createTour = function(tour){
        TourService.createTour(tour)
            .then(
            function(d) {
            	$scope.fetchAllTours;
            	$scope.addTourClicked = false;
            },
            function(errResponse){
                console.error('Error while creating Team');
            }
        );
    }

    $scope.updateTour = function(tour, id){
        TourService.updateTour(tour, id)
            .then(
            		$scope.fetchAllTours,
            function(errResponse){
                console.error('Error while updating Team');
            }
        );
    }

    $scope.deleteTour = function(id){
        TourService.deleteTour(id)
            .then(
            		$scope.fetchAllTours,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }

    $scope.submit = function() {
        if($scope.tour.tourid===null){
            console.log('Saving New Team', $scope.tour);
            createTour($scope.tour);
        }else{
            updateTour($scope.tour, $scope.tour.tourid);
            console.log('Tour updated with id ', $scope.tour.tourid);
        }
        reset();
    }

//    $scope.edit = function(id){
//        console.log('id to be edited', id);
//        for(var i = 0; i < $scope.teams.length; i++){
//            if($scope.teams[i].teamid === id) {
//                $scope.team = angular.copy($scope.teams[i]);
//                break;
//            }
//        }
//    }

    $scope.remove = function(id){
        console.log('id to be deleted', id);
        if($scope.tour.tourid === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteTour(id);
    }


    $scope.reset = function(){
        $scope.tour = {
        		tourid:'',
        		name:'',
        		venue:{
        			venueid : '',
        			name : '',
        			location : '',
        			incharge : '',
        			phone : ''
        		},
        		startdate : '',
        		enddate : '',
        		teamcount : '',
        		playercount : ''
        };
    }
    
}]);
