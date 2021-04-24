package com.digitalfacory.thechampion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalfacory.thechampion.model.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
	
	@Query(value = " SELECT player_id FROM tournament_player WHERE tournament_id=:tournamentId and active=1 ", nativeQuery = true)
	public List<Integer> findAllActivePlayers(Integer tournamentId);
	
	@Query(value = " UPDATE tournament_player set active=0 WHERE tournament_id=:tournamentId and player_id=:playerId ", nativeQuery = true)
	public void updatePLayerActive(Integer tournamentId, Integer playerId);
}
