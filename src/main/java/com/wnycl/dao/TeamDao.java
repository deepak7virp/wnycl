package com.wnycl.dao;

import java.util.List;

import com.wnycl.model.Team;

public interface TeamDao {
	Team findById(int id);
	
	Team findByName(String name);
	
	void save(Team team);
	
	void deleteById(int id);
	
	List<Team> findAllTeams();
}
