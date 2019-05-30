package com.revature.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

@Path("/scores")
public class FantasyPoints {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response scores(){
		ArrayList<TeamScores> teamScores=new ArrayList();
		List<String> teams=new ArrayList<>();
		HashMap<String, BigDecimal> hashmap=new HashMap();
		List<Player> players=new ArrayList<>();
		SimWeek simweek=new SimWeek();
		PlayerImp playerImp=new PlayerImp();
		players=simweek.getAllPlayers();
		for(Player p:players){
			if(!teams.contains(p.getF_team())){
				teams.add(p.getF_team());
			}
			
		}
		for(String p:teams){
			TeamScores teas=new TeamScores();
			teas.setTeam(p);
			teamScores.add(teas);
			
			
		}
		JSONArray team = new JSONArray();
		for(TeamScores t:teamScores){
			for(Player p:players){
				if(t.getTeam().equals(p.getF_team())){
					
					double temp=p.getFps();
					temp=temp+t.getteamFps();
					t.setteamFps(temp);
					
					
				}
			}
		}
		
		JSONArray array = new JSONArray();
		JSONObject mainObject=new JSONObject(true);
		JSONObject ns[]=new JSONObject[teamScores.size()];
		int i=0;
		for(TeamScores t:teamScores){
			JSONObject obj = new JSONObject(true);
			
			obj.put("team", t);
			array.put(obj);
			
			
		}
		
		ArrayList<TeamScoresFormat> teamsScoreFormat=new ArrayList<>();
		TeamScoresFormat teamScoreFormat =  new TeamScoresFormat(teamScores);
		Gson gson=new Gson();
		String jsonString = gson.toJson(array);
		//jsonString = jsonString.substring(2, jsonString.length() - 2);
		return Response.status(Response.Status.OK).entity(jsonString).build();
		
	}
}