package com.digitalfacory.thechampion.model.compositeIds;

import java.io.Serializable;


public class TournamentPlayerId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer tournamentId;
	private Integer playerId;
	
	public TournamentPlayerId() {
		super();
	}

	public TournamentPlayerId(Integer tournamentId, Integer playerId) {
		super();
		this.setTournamentId(tournamentId);
		this.setPlayerId(playerId);
	}
	
	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public Integer getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(Integer tournamentId) {
		this.tournamentId = tournamentId;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	
}
