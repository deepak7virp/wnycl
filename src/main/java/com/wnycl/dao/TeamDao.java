package com.wnycl.dao;

import java.util.List;

import com.wnycl.model.Team;

public interface TeamDao {
	Team findById(long id);
	
	Team findByName(String name);
	
	void save(Team team);
	
	void deleteById(long id);
	
	List<Team> findAllTeams();
}
