package com.digitalfacory.thechampion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalfacory.thechampion.model.Player;
import com.digitalfacory.thechampion.service.PlayerService;
import com.digitalfacory.thechampion.utls.Utils;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
public class PlayerController {
	
	@Autowired
	Utils utils;
	
	@Autowired
	PlayerService playerService;
	
	@GetMapping("/players")
	public ResponseEntity<?> getAllPlayers() {
		try {
			return new ResponseEntity<>(playerService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}
	
	@PostMapping("/players")
	ResponseEntity<?> createNewPlayer(@RequestBody Player player) {
		try {
			return new ResponseEntity<>(playerService.addNewPlayer(player), HttpStatus.CREATED);
		} catch (Exception e) {
			return utils.returnError(e);
		}
	}

}
