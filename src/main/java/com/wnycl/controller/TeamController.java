package com.wnycl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wnycl.model.Team;
import com.wnycl.service.TeamService;

@RestController
public class TeamController {

	@Autowired
	TeamService teamService;

	// -------------------Retrieve All Teams--------------------------------------------------------
	@RequestMapping(value = "/teams/", method = RequestMethod.GET)
	public ResponseEntity<List<Team>> listAllTeams() {
		List<Team> teams = teamService.findAllTeams();
		if (teams.isEmpty()) {
			return new ResponseEntity<List<Team>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
	}

	// -------------------Retrieve Single Team--------------------------------------------------------

	@RequestMapping(value = "/team/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Team> getTeam(@PathVariable("id") long id) {
		System.out.println("Fetching Team with id " + id);
		Team team = teamService.findById(id);
		if (team == null) {
			System.out.println("Team with id " + id + " not found");
			return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Team>(team, HttpStatus.OK);
	}

	// -------------------Create a Team--------------------------------------------------------

	@RequestMapping(value = "/team/", method = RequestMethod.POST)
	public ResponseEntity<Void> createTeam(@RequestBody Team team, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Team " + team.getName());

//		if (teamService.isTeamExist(team)) {
//			System.out.println("A Team with name " + team.getName() + " already exist");
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}

		teamService.saveTeam(team);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/team/{id}").buildAndExpand(team.getTeamid()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Team--------------------------------------------------------

	@RequestMapping(value = "/team/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Team> updateTeam(@PathVariable("id") long id, @RequestBody Team team) {
		System.out.println("Updating Team " + id);

		Team currentTeam = teamService.findById(id);

		if (currentTeam == null) {
			System.out.println("Team with id " + id + " not found");
			return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
		}

		currentTeam.setName(team.getName());
		currentTeam.setCity(team.getCity());
		currentTeam.setCaptain(team.getCaptain());

		teamService.updateTeam(currentTeam);
		return new ResponseEntity<Team>(currentTeam, HttpStatus.OK);
	}

	// ------------------- Delete a Team--------------------------------------------------------

	@RequestMapping(value = "/team/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Team> deleteTeam(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting Team with id " + id);

		Team team = teamService.findById(id);
		if (team == null) {
			System.out.println("Unable to delete. Team with id " + id + " not found");
			return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
		}

		teamService.deleteTeamById(id);
		return new ResponseEntity<Team>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Teams--------------------------------------------------------

	@RequestMapping(value = "/team/", method = RequestMethod.DELETE)
	public ResponseEntity<Team> deleteAllTeams() {
		System.out.println("Deleting All Teams");

		// teamService.deleteAllTeams();
		return new ResponseEntity<Team>(HttpStatus.NO_CONTENT);
	}
}
