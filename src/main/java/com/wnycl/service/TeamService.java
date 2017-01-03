package com.wnycl.service;

import java.util.List;

import com.wnycl.model.Team;

public interface TeamService {
	Team findById(int id);
	
	Team findByName(String name);
	
	void saveTeam(Team team);
	
	void updateTeam(Team team);
	
	void deleteTeamById(Integer id);

	List<Team> findAllTeams(); 
	
	boolean isTeamUnique(Integer id, String name);
}
