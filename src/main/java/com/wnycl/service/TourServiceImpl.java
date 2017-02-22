package com.wnycl.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wnycl.dao.TourDao;
import com.wnycl.model.Tournament;
import com.wnycl.model.Venue;

@Service("tourService")
@Transactional
public class TourServiceImpl implements TourService{

	@Autowired
	private TourDao dao;
	
	@Override
	public Tournament findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Tournament findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Override
	public Tournament findByVenue(Venue venue) {
		// TODO Auto-generated method stub
		return dao.findByVenue(venue);
	}

	@Override
	public void updateTour(Tournament tour) {
		// TODO Auto-generated method stub
		dao.updateTour(tour);
	}

	@Override
	public void save(Tournament tour) {
		// TODO Auto-generated method stub
		dao.save(tour);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<Tournament> getAllTournaments() {
		// TODO Auto-generated method stub
		return dao.getAllTournaments();
	}

	@Override
	public List<Tournament> getPastTournaments(Date currentDate) {
		// TODO Auto-generated method stub
		return dao.getPastTournaments(currentDate);
	}

	@Override
	public List<Tournament> getFutureTournaments(Date currentDate) {
		// TODO Auto-generated method stub
		return dao.getFutureTournaments(currentDate);
	}

	@Override
	public List<Tournament> getLiveTournaments(Date currentDate) {
		// TODO Auto-generated method stub
		return dao.getLiveTournaments(currentDate);
	}

}
