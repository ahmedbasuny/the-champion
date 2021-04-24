package com.digitalfacory.thechampion.controller;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.digitalfacory.thechampion.model.Match;
import com.digitalfacory.thechampion.model.Tournament;
import com.digitalfacory.thechampion.service.MatchService;
import com.digitalfacory.thechampion.service.PlayerService;
import com.digitalfacory.thechampion.service.TournamentService;
import com.digitalfacory.thechampion.utls.Utils;

@WebMvcTest(controllers = MatchController.class)
class MatchControllerTest {
	
	@MockBean
	MatchService matchServie;
	
	@MockBean
	PlayerService playerServie;
	
	@MockBean
	TournamentService tournamentServie;
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private Utils utils;

	@Test
	void testGetAllMatches() throws Exception {
		Tournament mockTournamemt = new Tournament("champions league"); 
		Match mockMatch1 = new Match(1, 1, 5, "12", "21", 5, mockTournamemt);
		Match mockMatch2 = new Match(2, 2, 3, "16", "21", 5, mockTournamemt);
		List<Match> matchList = new ArrayList<>();
		matchList.add(mockMatch1);
		matchList.add(mockMatch2);
		Mockito.when(this.matchServie.getAll()).thenReturn(matchList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/matches").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)));

	}

	@Test
	void testUpdateMatchResults() throws Exception {
		Tournament mockTournamemt = new Tournament("champions league");
		Match mockMatch = new Match(1, 1, 5, "12", "21", 5, mockTournamemt);
		Mockito.when(this.matchServie.updateMatchResult(mockMatch, 1)).thenReturn(mockMatch);
		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/matches/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(400));
	}

}
