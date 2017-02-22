package com.wnycl.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wnycl.model.Tournament;
import com.wnycl.model.Venue;

@Repository("tourDao")
public class TourDaoImpl extends AbstractDao<Integer, Tournament> implements TourDao{

	@Override
	public Tournament findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public Tournament findByName(String name) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		Tournament tour = (Tournament)crit.uniqueResult();
		return tour;
	}

	@Override
	public Tournament findByVenue(Venue venue) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("venue.venueid", venue.getVenueid()));
		Tournament tour = (Tournament)crit.uniqueResult();
		return tour;
	}

	@Override
	public void updateTour(Tournament tour) {
		// TODO Auto-generated method stub
		update(tour);
	}

	@Override
	public void save(Tournament tour) {
		// TODO Auto-generated method stub
		save(tour);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Tournament tour = (Tournament)crit.uniqueResult();
		delete(tour);
	}

	@Override
	public List<Tournament> getAllTournaments() {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Tournament> tours = (List<Tournament>) criteria.list();
		return tours;
	}

	@Override
	public List<Tournament> getPastTournaments(Date currentDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tournament> getFutureTournaments(Date currentDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tournament> getLiveTournaments(Date currentDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
