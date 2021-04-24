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
import com.digitalfacory.thechampion.service.PlayerService;
import com.digitalfacory.thechampion.service.TournamentService;
import com.digitalfacory.thechampion.utls.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = PlayerController.class)
class PlayerControllerTest {
	
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
	void testGetAllPlayers() throws Exception {
		Player[] mockPlayers = {
                new Player("Ahmed Basuny", "13"),
                new Player("refaat ismail", "153"),
                new Player("Mona tawfiq", "123"),
                new Player("Adham sabry", "139")};
		Mockito.when(this.playerServie.getAll()).thenReturn(Arrays.asList(mockPlayers));
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/players").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(4)));

	}

	@Test
	void testCreateNewPlayer() throws Exception {
		Player mockPlayer = new Player("Ahmed Basuny", "13");
		Mockito.when(this.playerServie.addNewPlayer(mockPlayer)).thenReturn(mockPlayer);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/players").accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(mockPlayer)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

}
