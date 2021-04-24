package com.digitalfacory.thechampion.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalfacory.thechampion.exception.TournamentDataNotValidException;
import com.digitalfacory.thechampion.model.Player;
import com.digitalfacory.thechampion.model.Tournament;
import com.digitalfacory.thechampion.model.custom.TournamentPlayerModel;
import com.digitalfacory.thechampion.repository.PlayerRepository;
import com.digitalfacory.thechampion.repository.TournamentRepository;
import com.digitalfacory.thechampion.utls.Config;

@Service
public class TournamentService {

	@Autowired
	TournamentRepository tournamentRepo;
	
	@Autowired
	PlayerRepository playertRepo;
	
	@Autowired
	MatchService matchService;
	
	public List<Tournament> getAll() {
		return tournamentRepo.findAll();
	}

	public Tournament addNewTournament(Tournament tournament) throws Exception {
		this.validateTournamentrData(tournament);
		return tournamentRepo.save(tournament);
	}
	
	public boolean validateTournamentrData(Tournament tournament) throws Exception {
		if (tournament.getName().trim().equals("")) {
			throw new TournamentDataNotValidException();
		}
		return true;
	}
	
	public void addPlayertoTournament(TournamentPlayerModel tournamentPlayerModel) throws Exception {
		Tournament tournament = tournamentRepo.getOne(tournamentPlayerModel.getTournamentId());
		if (tournament.getPlayers().size() < Config.MAX_NUMBER_OF_PLAYERS_IN_TOURNAMENT) {
			Player player = playertRepo.getOne(tournamentPlayerModel.getPlayerId());
			tournament.getPlayers().add(player);
			tournamentRepo.save(tournament);
		} else {
			throw new Exception("the league already complete with the max no. of players");
		}
	}

	public List<Player> getAllPlayersByTournament(Integer tournamentId) {
		Tournament tournament = tournamentRepo.getOne(tournamentId);
		return playertRepo.findAllByTournaments(tournament);
	}

	public List<Integer> caluclateNewRoundMatches(Integer tournamentId) {
		
		Tournament tournament = tournamentRepo.getOne(tournamentId);
		List<Integer> players = tournamentRepo.findAllActivePlayers(tournamentId);
		if (players.size() < 2) {
			System.out.println("we have a winner..." + players.get(0));
		} else {
			setMatches(players, tournament);
		}
		return players;
	}
	
	public void setMatches(List<Integer> players, Tournament tournament) {
		List<Integer> currentPlayers = players;
		if (currentPlayers.size() < 2) {
			return;
		} else {
			Integer firstPlayer = currentPlayers.get(new Random().nextInt(currentPlayers.size()));
			currentPlayers.remove(firstPlayer);
			Integer secondPlayer = currentPlayers.get(new Random().nextInt(currentPlayers.size()));
			currentPlayers.remove(secondPlayer);
			matchService.createNewMatch(firstPlayer, secondPlayer, tournament);
			setMatches(currentPlayers, tournament);
		}
	} 
	
	public void updatePlayerActive(Integer tournamentId, Integer playerId) {
		tournamentRepo.updatePLayerActive(tournamentId, playerId);
	}
}
