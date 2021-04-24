package com.digitalfacory.thechampion.controller;

import java.util.Arrays;

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

import com.digitalfacory.thechampion.model.Player;
import com.digitalfacory.thechampion.model.Tournament;
import com.digitalfacory.thechampion.service.PlayerService;
import com.digitalfacory.thechampion.service.TournamentService;
import com.digitalfacory.thechampion.utls.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = TournamentController.class)
class TournamentControllerTest {

	@MockBean
	PlayerService playerServie;
	
	@MockBean
	TournamentService tournamentServie;
	
	@MockBean
    private Utils utils;
	
	@Autowired
    private MockMvc mockMvc;
	

	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void testGetAllTournaments() throws Exception {
		Tournament[] mockTournaments = {
                new Tournament("Ramdan League"),
                new Tournament("Champions League"),
                new Tournament("Premier League"),
                new Tournament("Egyption League"),
                };
		Mockito.when(this.tournamentServie.getAll()).thenReturn(Arrays.asList(mockTournaments));
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tournaments").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(4)));
	}

	@Test
	void testCreateNewTournament() throws Exception {
		Tournament mockTournament = new Tournament("Champions League");
		Mockito.when(this.tournamentServie.addNewTournament(mockTournament)).thenReturn(mockTournament);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/tournaments").accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(mockTournament)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	void testGetAllTournamentPlayers() throws Exception {
		Player[] mockPlayers = {
                new Player("Ahmed Basuny", "13"),
                new Player("refaat ismail", "153"),
                new Player("Mona tawfiq", "123"),
                new Player("Adham sabry", "139")};
		Mockito.when(this.tournamentServie.getAllPlayersByTournament(1)).thenReturn(Arrays.asList(mockPlayers));
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tournaments/1/players").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(4)));
	}
}
