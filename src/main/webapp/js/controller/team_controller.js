'use strict';

angular.module('myApp').controller('TeamController', ['$scope', 'TeamService','PlayerService', function($scope, TeamService, PlayerService) {
    $scope.team={
    		teamid:'',
    		name:'',
    		city:'',
    		captain: {
    			playerid : '',
    			firstname : '',
    			lastname : '',
    			dob : '',
    			email : '',
    			phone : '',
    			active : ''
    		}
    };
    $scope.row = {
    		glyphs : {
    			edit : true,
        		submit : false,
        		cancel : false
    		}
    
    }
    $scope.teams=[];
    $scope.players = [];
    $scope.addTeamClicked = false;
    $scope.rows = {};
    
    $scope.edit = function(team){
    	PlayerService.findPlayersByTeam(team.teamid)
	        .then(
	        function(d) {
	            $scope.players = d;
	        },
	        function(errResponse){
	            console.error('Error while fetching players');
	        }
	    );
    	$scope.team = JSON.parse(JSON.stringify(team));
    	$scope.rows[team.teamid].glyphs.edit = false;
        $scope.rows[team.teamid].glyphs.submit = true;
        $scope.rows[team.teamid].glyphs.cancel = true;
    }
    $scope.assignCaptain = function(teamid){
    	 PlayerService.findPlayersByTeam(teamid)
	         .then(
	         function(d) {
	             $scope.players = d;
	             $scope.rows[teamid].assignCaptainEnable = true;
	             $scope.rows[teamid].glyphs.edit = false;
	             $scope.rows[teamid].glyphs.submit = false;
	             $scope.rows[teamid].glyphs.cancel = true;
	         },
	         function(errResponse){
	             console.error('Error while fetching players');
	         }
	     );
    }
    
    $scope.assignPlayerAsCaptain = function(teamid, playerid){
    	TeamService.assignCaptain(teamid,playerid)
    				.then(
    				function(d){
    					console.log("assigned");
    					$scope.teams = d;
    					$scope.teams.forEach(function(team, index, array){
    	                	$scope.rows[team.teamid] = JSON.parse(JSON.stringify($scope.row));
    	                });
    				},
    				function(errResponse){
    					console.error('Error while Assigning captain');
    				}
    			);
    }
    
    $scope.addClick = function(){
    	$scope.addTeamClicked = true;
    	$scope.rows[teamid].glyphs.edit = true;
        $scope.rows[teamid].glyphs.submit = false;
        $scope.rows[teamid].glyphs.cancel = false;
    }
    
    $scope.fetchAllTeams = function(){
        TeamService.fetchAllTeams()
            .then(
            function(d) {
                $scope.teams = d;
                $scope.teams.forEach(function(team, index, array){
                	$scope.rows[team.teamid] = JSON.parse(JSON.stringify($scope.row));
                });
            },
            function(errResponse){
                console.error('Error while fetching Teams');
            }
        );
    }
    
    $scope.fetchAllTeams();

    $scope.createTeam = function(team){
        TeamService.createTeam(team)
            .then(
            function(d) {
            	$scope.fetchAllTeams;
            	$scope.addTeamClicked = false;
            	console.log("in Add tewam");
            },
            function(errResponse){
                console.error('Error while creating Team');
            }
        );
    }

    $scope.updateTeam = function(team, id){
        TeamService.updateTeam(team, id)
            .then(
            		$scope.fetchAllTeams,
            function(errResponse){
                console.error('Error while updating Team');
            }
        );
    }

    $scope.deleteTeam = function(id){
        TeamService.deleteTeam(id)
            .then(
            		$scope.fetchAllTeams,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }

    $scope.submit = function() {
        if($scope.team.teamid===null){
            console.log('Saving New Team', $scope.team);
            createUser($scope.team);
        }else{
            updateUser($scope.team, $scope.team.teamid);
            console.log('Team updated with id ', $scope.team.teamid);
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
        if($scope.team.teamid === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteTeam(id);
    }


    $scope.reset = function(){
        $scope.team={teamid:null,name:'',city:'',captain:''};
    }

}]);
