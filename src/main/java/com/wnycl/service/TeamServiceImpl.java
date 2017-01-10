package com.wnycl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wnycl.dao.TeamDao;
import com.wnycl.model.Team;

@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService{

	@Autowired
	private TeamDao dao;
	
	@Override
	public Team findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Team findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Override
	public void saveTeam(Team team) {
		// TODO Auto-generated method stub
		dao.save(team);
	}

	@Override
	public void updateTeam(Team team) {
		// TODO Auto-generated method stub
		Team entity = dao.findById(team.getId());
		entity.setName(team.getName());
		entity.setCity(team.getCity());
		//entity.setCaptainid(team.getCaptainId());
	}

	@Override
	public void deleteTeamById(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<Team> findAllTeams() {
		// TODO Auto-generated method stub
		return dao.findAllTeams();
	}

	@Override
	public boolean isTeamUnique(Integer id, String name) {
		// TODO Auto-generated method stub
		Team team = findById(id);
		return ( team == null || ((id != null) && (team.getName() == name)));
	}

}
