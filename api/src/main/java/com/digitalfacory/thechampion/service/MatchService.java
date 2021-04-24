package com.digitalfacory.thechampion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalfacory.thechampion.model.Match;
import com.digitalfacory.thechampion.model.Tournament;
import com.digitalfacory.thechampion.repository.MatchRepository;

@Service
public class MatchService {

	@Autowired
	MatchRepository matchRepo;
	
	public List<Match> getAll() {
		return matchRepo.findAll();
	}

	public void createNewMatch(Integer firstPlayer, Integer secondPlayer, Tournament tournament) {
		Match match = new Match();
		match.setFirstPlayerId(firstPlayer);
		match.setSecondPlayerId(secondPlayer);
		match.setTournament(tournament);
		matchRepo.save(match);
	}

	public Match updateMatchResult(Match newMatch, Integer matchId) {
		Match match = matchRepo.getOne(matchId);
		match.setFirstPlayerResult(newMatch.getFirstPlayerResult());
		match.setSecondPlayerResult(newMatch.getSecondPlayerResult());
		match.setWinnerId(newMatch.getWinnerId());
		return matchRepo.save(match);
	}
}
