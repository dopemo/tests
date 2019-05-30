package com.revature.rest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class TeamScores {

private String teamName;
private double teamFPS;
public String getTeam() {
	return teamName;
}
public void setTeam(String team) {
	this.teamName = team;
}
public double getteamFps() {
	return teamFPS;
}
public void setteamFps(double teamFps) {
	this.teamFPS = teamFps;
}
@Override
public String toString() {
	return "team:" + teamName + ", teamFps=" + teamFPS +" ";
}


}