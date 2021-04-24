package com.digitalfacory.thechampion.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Tournament {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String status = "NOT_STARTED";
	
	@ManyToMany
	@JoinTable(
	name = "tournament_player",
	joinColumns = @JoinColumn(name = "tournament_id"),
	inverseJoinColumns = @JoinColumn(name = "player_id"))
	private Set<Player> players;
	
	@OneToMany(mappedBy="tournament")
	private Set<Match> matches;
	
	public Tournament() {}

	public Tournament(String name, String status) {
		super();
		this.name = name;
		this.status = status;
	}
	
	public Tournament(String name) {
		super();
		this.name = name;
	}

	public Set<Match> getMatches() {
		return matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
