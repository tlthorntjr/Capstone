package com.twowire.data;

import org.apache.xmlrpc.XmlRpcException;

public interface DataConnection {

	DataConfiguration getConfig();
	
	String login();
	
	boolean logout(String loginTokin) throws XmlRpcException;

}
