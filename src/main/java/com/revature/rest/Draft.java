package com.revature.rest;


import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/draft")
public class Draft {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/{fteam}")
	public Player draft(@PathParam("id") int id,@PathParam("fteam") String fteam){
		PlayerImp playerImp=new PlayerImp();
		playerImp.draftPlayer(id, fteam);
		Player player=new Player();
		List<Player> players=playerImp.getAllPlayers();
		for(Player p: players){
			if(p.getPlayer_id()==id){
				player=p;
			}
		}
		player.setF_team(fteam);
		return player;
		

	

}
}