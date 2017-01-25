package com.wnycl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wnycl.model.Team;

@Repository("teamDao")
public class TeamDaoImpl extends AbstractDao<Integer, Team> implements TeamDao {

	@Override
	public Team findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public Team findByName(String name) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		Team team = (Team)crit.uniqueResult();
		return team;
	}

	@Override
	public void save(Team team) {
		// TODO Auto-generated method stub
		persist(team);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Team team = (Team)crit.uniqueResult();
		delete(team);
	}

	@Override
	public List<Team> findAllTeams() {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Team> teams = (List<Team>) criteria.list();
		return teams;
	}

	@Override
	public void updateTeam(Team team) {
		// TODO Auto-generated method stub
		update(team);
	}

}
