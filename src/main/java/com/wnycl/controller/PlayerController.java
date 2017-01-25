package com.wnycl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wnycl.model.Player;
import com.wnycl.model.Team;
import com.wnycl.service.PlayerService;
import com.wnycl.service.TeamService;

@RestController
public class PlayerController {

	@Autowired
    PlayerService playerService;
	
	@Autowired
	TeamService teamService;
	
//-------------------Retrieve All Players in a Team--------------------------------------------------------
    
    @RequestMapping(value = "/player/{teamid}", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> listAllPlayers(@PathVariable("teamid") String teamid) {
    	List<Player> players = playerService.findPlayersByTeam(Integer.parseInt(teamid));
        if(players.isEmpty()){
            return new ResponseEntity<List<Player>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }        
        return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
    }
}
