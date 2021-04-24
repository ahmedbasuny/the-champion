package com.digitalfacory.thechampion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalfacory.thechampion.exception.PlayerDataNotValidException;
import com.digitalfacory.thechampion.exception.PlayerExistException;
import com.digitalfacory.thechampion.model.Player;
import com.digitalfacory.thechampion.repository.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository playerRepo;

	public List<Player> getAll() {
		return playerRepo.findAll();
	}

	public Player addNewPlayer(Player player) throws Exception {
		this.validatePlayerData(player);
		return playerRepo.save(player);
	}
	
	public boolean validatePlayerData(Player player) throws Exception {
		if (player.getName().trim().equals("") || player.getJobId().trim().equals("")) {
			throw new PlayerDataNotValidException();
		} else if (playerRepo.existsByJobId(player.getJobId())) {
			throw new PlayerExistException(player.getJobId());
		}
		return true;
	}
}
