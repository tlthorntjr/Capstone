package com.twowire.data;

public interface DataConnection {

	DataConfiguration getConfig();
	
	String login();
	
	boolean logout(String loginTokin);

}
