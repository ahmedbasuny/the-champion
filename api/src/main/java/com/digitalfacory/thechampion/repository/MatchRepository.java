package com.digitalfacory.thechampion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalfacory.thechampion.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

}
