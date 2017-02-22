package com.wnycl.controller;

import java.util.Date;
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
import com.wnycl.model.Tournament;
import com.wnycl.service.TourService;

@RestController
public class TourController {

	@Autowired
	TourService tourService;

	// -------------------Retrieve All Teams--------------------------------------------------------
	@RequestMapping(value = "/allTours/", method = RequestMethod.GET)
	public ResponseEntity<List<Tournament>> listAllTours() {
		List<Tournament> tours = tourService.getAllTournaments();
		if (tours.isEmpty()) {
			return new ResponseEntity<List<Tournament>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Tournament>>(tours, HttpStatus.OK);
	}
	
	// -------------------Retrieve Single Tour--------------------------------------------------------

	@RequestMapping(value = "/tour/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tournament> getTour(@PathVariable("id") Integer id) {
		System.out.println("Fetching Tour with id " + id);
		Tournament tour = tourService.findById(id);
		if (tour == null) {
			System.out.println("Tour with id " + id + " not found");
			return new ResponseEntity<Tournament>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Tournament>(tour, HttpStatus.OK);
	}
	
	// -------------------Retrieve Current Tours--------------------------------------------------------
	@RequestMapping(value = "/liveTours/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tournament>> getLiveTours(@PathVariable("id") Date date) {
		List<Tournament> tours = tourService.getLiveTournaments(date);
		if (tours.size() == 0) {
			return new ResponseEntity<List<Tournament>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Tournament>>(tours, HttpStatus.OK);
	}
	
	// -------------------Retrieve Past Tours--------------------------------------------------------
	@RequestMapping(value = "/pastTours/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tournament>> getPastTours(@PathVariable("id") Date date) {
		List<Tournament> tours = tourService.getPastTournaments(date);
		if (tours.size() == 0) {
			return new ResponseEntity<List<Tournament>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Tournament>>(tours, HttpStatus.OK);
	}
		
	// -------------------Retrieve Current Tours--------------------------------------------------------
	@RequestMapping(value = "/futureTour/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tournament>> getFutureTours(@PathVariable("id") Date date) {
		List<Tournament> tours = tourService.getFutureTournaments(date);
		if (tours.size() == 0) {
			return new ResponseEntity<List<Tournament>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Tournament>>(tours, HttpStatus.OK);
	}
	
	// -------------------Create a Tour--------------------------------------------------------
	@RequestMapping(value = "/createTour/", method = RequestMethod.POST)
	public ResponseEntity<Void> createTour(@RequestBody Tournament tour, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Tour " + tour.getName());
		tourService.save(tour);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/team/{id}").buildAndExpand(tour.getTourid()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Tour--------------------------------------------------------
	@RequestMapping(value = "/updateTour/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Tournament> updateTeam(@PathVariable("id") String id, @RequestBody Team team) {
		System.out.println("Updating Tour " + id);
		Tournament currentTour = tourService.findById(Integer.parseInt(id));
		if (currentTour == null) {
			System.out.println("Tour with id " + id + " not found");
			return new ResponseEntity<Tournament>(HttpStatus.NOT_FOUND);
		}
		currentTour.setName(team.getName());
		tourService.updateTour(currentTour);
		return new ResponseEntity<Tournament>(currentTour, HttpStatus.OK);
	}
	
	// ------------------- Delete a Tour--------------------------------------------------------
	@RequestMapping(value = "/deleteTour/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Tournament> deleteTeam(@PathVariable("id") Integer id) {
		System.out.println("Fetching & Deleting Tour with id " + id);

		Tournament tour = tourService.findById(id);
		if (tour == null) {
			System.out.println("Unable to delete. Tour with id " + id + " not found");
			return new ResponseEntity<Tournament>(HttpStatus.NOT_FOUND);
		}

		tourService.deleteById(id);
		return new ResponseEntity<Tournament>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Tours--------------------------------------------------------
	@RequestMapping(value = "/deleteAllTours/", method = RequestMethod.DELETE)
	public ResponseEntity<Tournament> deleteAllTours() {
		System.out.println("Deleting All Tours");
		
		// teamService.deleteAllTeams();
		return new ResponseEntity<Tournament>(HttpStatus.NO_CONTENT);
	}
}
