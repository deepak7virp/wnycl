package com.wnycl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wnycl.model.Player;
import com.wnycl.model.Team;

@Repository("playerDao")
public class PlayerDaoImpl extends AbstractDao<Integer, Player> implements PlayerDao {

	@Override
	public Player findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public Player findByName(String name) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("firstname", name));
		Player player = (Player)crit.uniqueResult();
		return player;
	}

	@Override
	public void save(Player team) {
		// TODO Auto-generated method stub
		persist(team);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("playerid", id));
		Player player = (Player)crit.uniqueResult();
		delete(player);
	}

	@Override
	public List<Player> findAllPlayers() {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstname"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Player> players = (List<Player>) criteria.list();
		return players;
	}

	@Override
	public List<Player> findPlayersByTeam(int id) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("teamid", id));
		List<Player> players = (List<Player>)crit.list();
		return players;
	}

}
