package com.digitalfacory.thechampion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel(description="Match Details")
public class Match {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer firstPlayerId;
	
	private Integer secondPlayerId;
	
	private String firstPlayerResult;
	
	private String secondPlayerResult;
	
	private Integer winnerId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="tournament_id", nullable=false)
	private Tournament tournament;
	
	public Match() {}

	public Match(Integer id, Integer firstPlayerId, Integer secondPlayerId, String firstPlayerResult,
			String secondPlayerResult, Integer winnerId, Tournament tournament) {
		super();
		this.id = id;
		this.firstPlayerId = firstPlayerId;
		this.secondPlayerId = secondPlayerId;
		this.firstPlayerResult = firstPlayerResult;
		this.secondPlayerResult = secondPlayerResult;
		this.winnerId = winnerId;
		this.tournament = tournament;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFirstPlayerId() {
		return firstPlayerId;
	}

	public void setFirstPlayerId(Integer firstPlayerId) {
		this.firstPlayerId = firstPlayerId;
	}

	public Integer getSecondPlayerId() {
		return secondPlayerId;
	}

	public void setSecondPlayerId(Integer secondPlayerId) {
		this.secondPlayerId = secondPlayerId;
	}

	public String getFirstPlayerResult() {
		return firstPlayerResult;
	}

	public void setFirstPlayerResult(String firstPlayerResult) {
		this.firstPlayerResult = firstPlayerResult;
	}

	public String getSecondPlayerResult() {
		return secondPlayerResult;
	}

	public void setSecondPlayerResult(String secondPlayerResult) {
		this.secondPlayerResult = secondPlayerResult;
	}

	public Integer getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(Integer winnerId) {
		this.winnerId = winnerId;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	
	
}
