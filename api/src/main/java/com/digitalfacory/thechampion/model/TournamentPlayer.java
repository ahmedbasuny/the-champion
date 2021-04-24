package com.digitalfacory.thechampion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.digitalfacory.thechampion.model.compositeIds.TournamentPlayerId;

@Entity(name = "tournament_player")
@IdClass(TournamentPlayerId.class)
public class TournamentPlayer {
	
	@Id
	@Column(name = "tournament_id")
	private Integer tournamentId;
	
	@Id
	@Column(name = "player_id")
	private Integer playerId;
	
	@Column(name = "active", columnDefinition = "integer default 1")
	private Integer active;
	
	public TournamentPlayer() {}

	public TournamentPlayer(Integer tournamentId, Integer playerId, Integer active) {
		super();
		this.tournamentId = tournamentId;
		this.playerId = playerId;
		this.active = active;
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

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

}
