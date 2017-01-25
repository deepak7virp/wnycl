package com.wnycl.service;

import java.util.List;

import com.wnycl.model.Player;
import com.wnycl.model.Team;

public interface TeamService {
	Team findById(int id);
	
	Team findByName(String name);
	
	void saveTeam(Team team);
	
	void updateTeam(Team team);
	
	void assignCaptain(int teamid, Player player);
	
	void deleteTeamById(int id);

	List<Team> findAllTeams(); 
	
	boolean isTeamUnique(int id, String name);
	
	boolean isTeamExist(Team team);
}
