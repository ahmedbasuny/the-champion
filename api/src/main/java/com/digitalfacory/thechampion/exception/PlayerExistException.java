package com.digitalfacory.thechampion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlayerExistException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PlayerExistException(String memberJobId) {
		super("Digital Factory member with Id " + memberJobId + " is already an active player in the champion league.");
	}
}
