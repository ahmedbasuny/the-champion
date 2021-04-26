package com.digitalfacory.thechampion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalfacory.thechampion.model.Tournament;
import com.digitalfacory.thechampion.model.custom.TournamentPlayerModel;
import com.digitalfacory.thechampion.service.TournamentService;
import com.digitalfacory.thechampion.utls.Utils;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
public class TournamentController {
	
	@Autowired
	Utils utils;
	
	@Autowired
	TournamentService tournamentServie;
	
	@GetMapping("/tournaments")
	public ResponseEntity<?> getAllTournaments() {
		try {
			return new ResponseEntity<>(tournamentServie.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}
	
	@GetMapping("/tournaments/{tournamentId}")
	public ResponseEntity<?> getTournament(@PathVariable Integer tournamentId) {
		try {
			return new ResponseEntity<>(tournamentServie.getTournament(tournamentId), HttpStatus.OK);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}
	
	@PostMapping("/tournaments")
	ResponseEntity<?> createNewTournament(@RequestBody Tournament tournament) {
		try {
			return new ResponseEntity<>(tournamentServie.addNewTournament(tournament), HttpStatus.CREATED);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}
	
	@PostMapping("/tournaments/players")
	ResponseEntity<?> joinPlayerToTournament(@RequestBody TournamentPlayerModel tournamentPlayerModel) {
		try {
			tournamentServie.addPlayertoTournament(tournamentPlayerModel);
			return new ResponseEntity<>("player joined the league successfully", HttpStatus.OK);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}
	
	@GetMapping("/tournaments/{tournamentId}/players")
	ResponseEntity<?> getAllTournamentPlayers(@PathVariable Integer tournamentId) {
		try {
			return new ResponseEntity<>(tournamentServie.getAllPlayersByTournament(tournamentId), HttpStatus.OK);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}
	
	@GetMapping("/tournaments/{tournamentId}/nextround")
	ResponseEntity<?> perpareNextRoundMatches(@PathVariable Integer tournamentId) {
		try {
			return new ResponseEntity<>(tournamentServie.caluclateNewRoundMatches(tournamentId), HttpStatus.OK);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}
	
	@PutMapping("/tournaments/players/active/{tournamentId}/{playerId}")
	ResponseEntity<?> updatePLayerActive(@PathVariable Integer tournamentId, @PathVariable Integer playerId) {
		try {
			tournamentServie.updatePlayerActive(tournamentId, playerId);
			return new ResponseEntity<>("updated successfully", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}

}
