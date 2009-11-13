package com.twowire.data;

import org.apache.xmlrpc.client.XmlRpcClient;

public interface DataConfiguration {
	
	boolean configure();
	
	XmlRpcClient getClient();

}
