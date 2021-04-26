# the-champion
API to manage tennis table league.

## Built With
* Java 11
* Spring Boot
* H2 in-memory DB
* Maven
* Swagger
* Actuator

### Build and Run
* Build with Maven.

Download the app. go inside project folder and run this maven commend.

`$ mvn clean install`
`$ mvn clean package spring-boot:run`

## Using the endpoints
* Once the app is up and running. you can check API documentation from this url
[Swagger API Documentation](http://localhost:8080/swagger-ui.html)

## Scenario Steps
* Add a new digital factory player to the champion system.
	http://localhost:8080/api/v1/players  	  					POST create new player {name, jobId}
* Get list of all players.
	http://localhost:8080/api/v1/players      					GET  List all players 
* Add new Tournament.
	http://localhost:8080/api/v1/tournaments  	  				POST create new tournament {name}
* Get List of all tournaments.
	http://localhost:8080/api/v1/tournaments  	  				GET List all tournaments
* Submit a participant request.
	http://localhost:8080/api/v1/tournaments/players  	  		POST Add player to tournament {tournamentId, playerId}

* Note: max number of players in tournament is configured as 12 players and this can be changed.
* We can start the league or get next round by calling the following API.
	http://localhost:8080/api/v1/tournaments/{tournamentId}/nextround  	  GET Start nextround
* The previous api will return the ids of the current player in the league.
* If we have one ID, so we have a winner.
* Otherwise it will automatic create random matches between the current players.
* Will have matches data with tournament data.
* We will have 3 matches a day and this could be handeled in front end.
* We will update match results for every match.
	http://localhost:8080/api/v1/matches/{matchId} 	  			PUT Update match result {firstPlayerResult, secondPlayerResult, winnerId}
* We will call update player status to set loser active to be 0.
	http://localhost:8080/api/v1/tournaments/players/active/{tournamentId}/{playerId} 	 PUT Update loser player status to be 0 so we can't include the player in next round.
* After we update all match results. we call next round again until we have a winner.

## access H2 Data 
http://localhost:8080/h2  password sa


## Unit/Integeration Test
* The project having integeration test for endpoint with Junit, Mokito and WebMvc.

## Actuator
* The project uses spring actuator for monitoring.
* [actuator metrics](http://localhost:8080/actuator/metrics)
* [actuator env](http://localhost:8080/actuator/env)
* [actuator health](http://localhost:8080/actuator/health)



