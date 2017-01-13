'use strict';
 
angular.module('myApp').controller('TeamController', ['$scope', 'TeamService', function($scope, TeamService) {
    var self = this;
    self.team={id:null,name:'',city:'',captain:''};
    self.teams=[];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 
 
    getAllTeams();
 
    function getAllTeams(){
        TeamService.getAllTeams()
            .then(
            function(d) {
                self.teams = d;
            },
            function(errResponse){
                console.error('Error while getting Teams');
            }
        );
    }
 
    function createTeam(team){
        TeamService.createTeam(team)
            .then(
            getAllTeams,
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
            getAllTeams,
            function(errResponse){
                console.error('Error while deleting Team');
            }
        );
    }
 
    function submit() {
        if(self.team.id===null){
            console.log('Saving New Team', self.team);
            createTeam(self.team);
        }else{
            updateTeam(self.team, self.team.id);
            console.log('Team updated with id ', self.team.id);
        }
        reset();
    }
 
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.teams.length; i++){
            if(self.teams[i].id === id) {
                self.team = angular.copy(self.teams[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.team.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteTeam(id);
    }
 
 
    function reset(){
        self.team={id:null,name:'',city:'',captain:''};
        $scope.myForm.$setPristine(); //reset Form
    }
}]);