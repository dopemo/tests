package com.revature.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class PlayerImp implements PostgresImp {
	public List<Player> getAllPlayers() {
		List<Player> players = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = Postgres.getConnection();

			stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery( "SELECT * FROM players;" );
	         while ( rs.next() ) {
	             
	             Player player= new Player();
	             player.setPlayer_id(rs.getInt("player_id"));
	             player.setFirstname(rs.getString("firstname"));
	             player.setLastname(rs.getString("lastname"));
	             player.setPosition(rs.getString("position"));
	             player.setR_team(rs.getString("rteam"));
	             player.setF_team(rs.getString("fteam"));
	             player.setFps(rs.getDouble("avg_fps"));
	             players.add(player);
	             
	            
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return players;
	}
	public void draftPlayer(int id, String f_team){
		Connection connection=null;
		PreparedStatement pstmt = null;
		String sql="UPDATE players SET fteam = ? WHERE player_id = ?";
		int affectedrows = 0;
		Player player=new Player();
        try {
        	connection = Postgres.getConnection();
        	pstmt = connection.prepareStatement(sql);
 
            pstmt.setString(1, f_team);
            pstmt.setInt(2, id);
 
            affectedrows = pstmt.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	



	

}
