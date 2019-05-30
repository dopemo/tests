package com.revature.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@Path("/fantasy")
public class FantasyController {

	
	
	@GET
	@Path("/{position}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> position(@PathParam("position") String position) {
		PlayerImp playersImp=new PlayerImp();
		List<Player> players=new ArrayList<Player>();
		List<Player> p_player=new ArrayList<Player>();
		Player p=new Player();
		players=playersImp.getAllPlayers();
		for(Player player:players){
			if(player.getPosition().equals(position)){
				p_player.add(player);
				
			}
		}
		return p_player;
	}
	
	@GET
	@Path("/individual")
	@Produces(MediaType.APPLICATION_JSON)
	public Player sayHelloName(@QueryParam("name") String name) {
		
		PlayerImp playersImp=new PlayerImp();
		List<Player> players=new ArrayList<Player>();
		Player p=new Player();
		players=playersImp.getAllPlayers();
		for(Player player:players){
			if(player.getFirstname().equals(name)||player.getLastname().equals(name)){
				p=player;
			}
		}
		return p;
	}
		
	
	@GET
	@Path("/players")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> getPrince() {
		PlayerImp playersImp=new PlayerImp();
		List<Player> players=new ArrayList<Player>();
		players=playersImp.getAllPlayers();

	
		return players;
		
	}
	
	
}
