package com.revature.rest;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/simweek")
public class SimWeek {
	private List<Player> players=new ArrayList<>();
	
	public SimWeek(){
		PlayerImp playersImp=new PlayerImp();
		this.players=playersImp.getAllPlayers();
		for(Player p:players){
			Random rand = new Random();
			double team = rand.nextInt(30);
			
			p.setFps(team);
			
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> simulate(){
		
        return players;
		
	}
	public List<Player> getAllPlayers(){
		return this.players;
	}
}
