package com.wnycl.service;

import java.util.List;

import com.wnycl.model.Player;
import com.wnycl.model.Team;

public interface PlayerService {

	Player findById(int id);
	
	Player findByName(String name);
	
	void savePlayer(Player player);
	
	void updatePlayer(Player player);
	
	void deletePlayerById(Integer id);

	List<Player> findAllPlayers(); 
	
	List<Player> findPlayersByTeam(int id);
	
	boolean isPlayerUnique(Integer id, String name);
}
