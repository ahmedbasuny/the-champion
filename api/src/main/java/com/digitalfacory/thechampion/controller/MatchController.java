package com.digitalfacory.thechampion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalfacory.thechampion.model.Match;
import com.digitalfacory.thechampion.service.MatchService;
import com.digitalfacory.thechampion.utls.Utils;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
public class MatchController {

	@Autowired
	MatchService matchService;
	
	@Autowired
	Utils utils;
	
	@GetMapping("/matches")
	public ResponseEntity<?> getAllMatches() {
		try {
			return new ResponseEntity<>(matchService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}
	
	@PutMapping("/matches/{matchId}")
	ResponseEntity<?> updateMatchResults(@RequestBody Match match, @PathVariable Integer matchId) {
		try {
			return new ResponseEntity<>(matchService.updateMatchResult(match, matchId), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}
}
