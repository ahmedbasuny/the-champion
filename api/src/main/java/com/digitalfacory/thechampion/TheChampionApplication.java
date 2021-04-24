package com.digitalfacory.thechampion;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.digitalfacory.thechampion.model.Player;
import com.digitalfacory.thechampion.model.Tournament;
import com.digitalfacory.thechampion.service.PlayerService;
import com.digitalfacory.thechampion.service.TournamentService;

@SpringBootApplication
public class TheChampionApplication implements CommandLineRunner {
	
	@Autowired
	PlayerService playerSerivce;
	
	@Autowired
	TournamentService tournamentService;

	public static void main(String[] args) {
		SpringApplication.run(TheChampionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Player[] players = {
                new Player("Ahmed Basuny", "13"),
                new Player("refaat ismail", "153"),
                new Player("Mona tawfiq", "123"),
                new Player("Adham sabry", "139"),
                new Player("qadry monem", "137"),
                new Player("sonia grahm", "130"),
                new Player("nadia mosad", "134"),
                };
        Arrays.asList(players).forEach(player -> {
			try {
				playerSerivce.addNewPlayer(player);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
        
        Tournament[] tournaments = {
                new Tournament("Ramdan League"),
                new Tournament("Champions League"),
                new Tournament("Premier League"),
                new Tournament("Egyption League"),
                };
        Arrays.asList(tournaments).forEach(tournament -> {
			try {
				tournamentService.addNewTournament(tournament);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
