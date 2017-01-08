package com.wnycl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wnycl.dao.PlayerDao;
import com.wnycl.dao.TeamDao;
import com.wnycl.model.Player;

@Service("playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	private PlayerDao dao;
	
	@Override
	public Player findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Player findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Override
	public void savePlayer(Player player) {
		// TODO Auto-generated method stub
		dao.save(player);
	}

	@Override
	public void updatePlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePlayerById(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<Player> findAllPlayers() {
		// TODO Auto-generated method stub
		return dao.findAllPlayers();
	}

	@Override
	public List<Player> findPlayersByTeam(int id) {
		// TODO Auto-generated method stub
		return dao.findPlayersByTeam(id);
	}

	@Override
	public boolean isPlayerUnique(Integer id, String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
