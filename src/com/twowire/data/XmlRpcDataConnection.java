package com.twowire.data;

import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;

public class XmlRpcDataConnection implements DataConnection {
	
    private final String USER_NAME = "tltjr";
    private final String PASSWORD  = "tltjr";
    private DataConfiguration config;
    
    public XmlRpcDataConnection(DataConfiguration config) {
    	this.config = config;
    }
    
	public XmlRpcDataConnection() {
		this.config = new XmlRpcConfiguration();
	}

	public String login() {
		Vector<String> loginParams = new Vector<String>(2);
		loginParams.add(USER_NAME);
		loginParams.add(PASSWORD);
		String loginToken = null;
		try {
			loginToken = (String) config.getClient().execute("jira1.login", loginParams);
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}
		return loginToken!=null ? loginToken : null;
	}
	
	public boolean logout(String loginToken) {
		Vector<String> logoutParams = new Vector<String>(1);
		logoutParams.add(loginToken);
		Boolean bool = false;
		try {
			bool = (Boolean) config.getClient().execute("jira1.logout", logoutParams);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("Logout successful: " + bool);
		return bool;
	}

	@Override
	public DataConfiguration getConfig() {
		return config;
	}
}
