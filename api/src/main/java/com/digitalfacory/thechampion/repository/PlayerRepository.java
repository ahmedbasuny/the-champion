package com.digitalfacory.thechampion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalfacory.thechampion.model.Player;
import com.digitalfacory.thechampion.model.Tournament;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	public boolean existsByJobId(String jobId);
	public List<Player> findAllByTournaments(Tournament tournament);
}
