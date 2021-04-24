package com.digitalfacory.thechampion.model.custom;

public class TournamentPlayerModel {

	private Integer tournamentId;
	private Integer playerId;
	
	public TournamentPlayerModel() {}

	public TournamentPlayerModel(Integer tournamentId, Integer playerId) {
		super();
		this.tournamentId = tournamentId;
		this.playerId = playerId;
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
