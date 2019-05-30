package com.revature.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/team")
public class Team {
	@GET
	@Path("/{teams}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> teams(@PathParam("teams") String teams) {
		
		PlayerImp playersImp=new PlayerImp();
		List<Player> players=new ArrayList<>();
		List<Player> p_players=new ArrayList<>();
		Player p=new Player();
		players=playersImp.getAllPlayers();
		for(Player player:players){
			if(player.getF_team().equalsIgnoreCase(teams)){
				p_players.add(player);
			}
		}
		return p_players;
	}
}
