'use strict';

angular.module('myApp').controller('PlayerController', ['$scope', 'PlayerService', 'TeamService', '$routeParams', function($scope, PlayerService, TeamService, $routeParams) {
    
	var teamID = $routeParams.teamID;//$route.current.$$route.teamid;
	var self = this;
    self.player={
    		playerid:null,
    		firstname:'',
    		lastname:'',
    		dob:'',
    		email:'',
    		phone:'',
    		active:'',
    		team: {
    			teamid : '',
    			name : '',
    			city : '',
    		}
    };
    self.players=[];
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    fetchAllPlayers(teamID);
    function fetchAllPlayers(teamid){
    	PlayerService.fetchAllPlayers(teamID)
	        .then(
	        function(d) {
	            self.players = d;
	            console.log(d);
	        },
	        function(errResponse){
	            console.error('Error while fetching Teams');
	        }
	    )
    }

    function createPlayer(player){
        PlayerService.createPlayer(player)
            .then(
            fetchAllPlayers,
            function(errResponse){
                console.error('Error while creating Team');
            }
        );
    }

    function updatePlayer(player, id){
        PlayerService.updatePlayer(player, id)
            .then(
            fetchAllPlayers,
            function(errResponse){
                console.error('Error while updating Team');
            }
        );
    }

    function deletePlayer(id){
        PlayerService.deletePlayer(id)
            .then(
            fetchAllPlayers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }

    function submit() {
        if(self.player.playerid===null){
            console.log('Saving New Team', self.player);
            createUser(self.player);
        }else{
            updateUser(self.player, self.player.playerid);
            console.log('Team updated with id ', self.player.playerid);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.players.length; i++){
            if(self.players[i].playerid === id) {
                self.player = angular.copy(self.players[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.player.playerid === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deletePlayer(id);
    }


    function reset(){
        self.player={playerid:null,name:'',city:'',captain:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
