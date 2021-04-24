package com.digitalfacory.thechampion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TournamentDataNotValidException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TournamentDataNotValidException() {
		super("Tournament data is not valid. Please make sure all required data are provided.");
	}
}
