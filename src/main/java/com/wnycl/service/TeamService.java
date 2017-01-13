package com.wnycl.service;

import java.util.List;

import com.wnycl.model.Team;

public interface TeamService {
	Team findById(long id);
	
	Team findByName(String name);
	
	void saveTeam(Team team);
	
	void updateTeam(Team team);
	
	void deleteTeamById(long id);

	List<Team> findAllTeams(); 
	
	boolean isTeamUnique(long id, String name);
	
	boolean isTeamExist(Team team);
}
