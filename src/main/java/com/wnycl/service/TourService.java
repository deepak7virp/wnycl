package com.wnycl.service;

import java.util.Date;
import java.util.List;

import com.wnycl.model.Tournament;
import com.wnycl.model.Venue;

public interface TourService {

Tournament findById(int id);
	
	Tournament findByName(String name);
	
	Tournament findByVenue(Venue venue);
	
	void updateTour(Tournament tour);
	
	void save(Tournament tour);
	
	void deleteById(int id);
	
	List<Tournament> getAllTournaments();
	
	List<Tournament> getPastTournaments(Date currentDate);
	
	List<Tournament> getFutureTournaments(Date currentDate);
	
	List<Tournament> getLiveTournaments(Date currentDate);
}
