'use strict';

angular.module('myApp').controller('PlayerController', ['$scope', '$routeParams','PlayerService', function($scope, $routeParams,PlayerService) {
    var self = this;
    self.player={    		
    			playerid : '',
    			firstname : '',
    			lastname : '',
    			dob : '',
    			teamid:'',
    			email : '',
    			phone : '',
    			active : ''    		
    };
    
    self.players=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

    findPlayersByTeam($routeParams.teamid);

    function findPlayersByTeam(teamid){
        PlayerService.findPlayersByTeam(teamid)
            .then(
            function(d) {
                self.players = d;
            },
            function(errResponse){
                console.error('Error while fetching players');
            }
        );
    }

    function createPlayers(team){
        TeamService.createTeams(team)
            .then(
            fetchAllTeams,
            function(errResponse){
                console.error('Error while creating Team');
            }
        );
    }

    function updatePlayer(team, id){
        PlayerService.updatePlayer(team, id)
            .then(
            fetchAllTeams,
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
        if(self.team.teamid===null){
            console.log('Saving New Team', self.team);
            createUser(self.team);
        }else{
            updateUser(self.team, self.team.teamid);
            console.log('Team updated with id ', self.team.teamid);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.teams.length; i++){
            if(self.teams[i].teamid === id) {
                self.team = angular.copy(self.teams[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.team.teamid === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteTeam(id);
    }

    function reset(){
        self.team={teamid:null,name:'',city:'',captain:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
