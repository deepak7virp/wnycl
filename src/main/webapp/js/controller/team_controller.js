'use strict';

angular.module('myApp').controller('TeamController', ['$scope', 'TeamService', function($scope, TeamService) {
    var self = this;
    self.team={
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
    
    self.teams=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllTeams();
   
    function fetchAllTeams(){
        TeamService.fetchAllTeams()
            .then(
            function(d) {
                self.teams = d;
            },
            function(errResponse){
                console.error('Error while fetching Teams');
            }
        );
    }

    function createTeam(team){
        TeamService.createTeam(team)
            .then(
            function(d) {
            	console.log("in Add tewam");
            },
            function(errResponse){
                console.error('Error while creating Team');
            }
        );
    }

    function updateTeam(team, id){
        TeamService.updateTeam(team, id)
            .then(
            fetchAllTeams,
            function(errResponse){
                console.error('Error while updating Team');
            }
        );
    }

    function deleteTeam(id){
        TeamService.deleteTeam(id)
            .then(
            fetchAllTeams,
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
