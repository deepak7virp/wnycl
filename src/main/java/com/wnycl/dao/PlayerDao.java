package com.wnycl.dao;

import java.util.List;

import com.wnycl.model.Player;
import com.wnycl.model.Team;



public interface PlayerDao {

	Player findById(int id);
	
	Player findByName(String name);
	
	void save(Player team);
	
	void deleteById(int id);
	
	List<Player> findAllPlayers();
	
	List<Player> findPlayersByTeam(int id);
}
