package com.wnycl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wnycl.model.Player;
import com.wnycl.model.Team;
import com.wnycl.service.PlayerService;
import com.wnycl.service.TeamService;

@RestController
public class AppRestController {
	@Autowired
    TeamService teamService;  //Service which will do all data retrieval/manipulation work
  
	@Autowired
    PlayerService playerService;  //Service which will do all data retrieval/manipulation work
     
    //-------------------Retrieve All Teams--------------------------------------------------------
      
    @RequestMapping(value = "/team/", method = RequestMethod.GET)
    public ResponseEntity<List<Team>> listAllTeams() {
        List<Team> teams = teamService.findAllTeams();
        if(teams.isEmpty()){
            return new ResponseEntity<List<Team>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
    }
    
    
    //-------------------Create a Team--------------------------------------------------------
    
    @RequestMapping(value = "/team/", method = RequestMethod.POST)
    public ResponseEntity<Void> createTeam(@RequestBody Team team,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Team " + team.getName());
        teamService.saveTeam(team);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Team/{id}").buildAndExpand(team.getTeamid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
    //-------------------Retrieve All Players in a Team--------------------------------------------------------
    
    @RequestMapping(value = "/player/{teamid}", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> listAllPlayers(@PathVariable("teamid") Integer teamid) {   
        List<Player> players = playerService.findPlayersByTeam(teamid);
        if(players.isEmpty()){
            return new ResponseEntity<List<Player>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }        
        return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
    }
     
    //-------------------Retrieve Single Team--------------------------------------------------------
      
    /*@RequestMapping(value = "/player/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> getTeam(@PathVariable("id") long id) {
        System.out.println("Fetching Team with id " + id);
        List<Player> players = playerService.findAllPlayers();
        if (players == null) {
            System.out.println("Team with id " + id + " not found");
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
    }
  */
      
      
    
  
     
      
    //------------------- Update a Team --------------------------------------------------------
      
    @RequestMapping(value = "/Team/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Team> updateTeam(@PathVariable("id") long id, @RequestBody Team Team) {
        System.out.println("Updating Team " + id);
          
        Team currentTeam = teamService.findById((int)id);
          
        if (currentTeam==null) {
            System.out.println("Team with id " + id + " not found");
            return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
        }
  
        currentTeam.setName(Team.getName());
        currentTeam.setCity(Team.getCity());
        //currentTeam.setC(Team.getEmail());
          
        teamService.updateTeam(currentTeam);
        return new ResponseEntity<Team>(currentTeam, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a Team --------------------------------------------------------
      
    @RequestMapping(value = "/Team/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Team> deleteTeam(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Team with id " + id);
  
        //Team Team = TeamService.findById(id);
//        if (Team == null) {
//            System.out.println("Unable to delete. Team with id " + id + " not found");
//            return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
//        }
  
        //TeamService.deleteTeamById(id);
        return new ResponseEntity<Team>(HttpStatus.NO_CONTENT);
    }
  
}