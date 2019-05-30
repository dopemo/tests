package com.revature.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class FantasyResource extends ResourceConfig {
	public FantasyResource() {
		packages("com.revature.rest");
	}
}
