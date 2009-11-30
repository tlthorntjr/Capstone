package com.twowire.data;

import java.util.HashMap;
import java.util.List;

import org.apache.xmlrpc.client.XmlRpcClient;

public class FakeXmlRpcClient extends XmlRpcClient {
	
	@Override
	public Object execute(String throwaway, List discard) {
		HashMap issue = new HashMap();
		issue.put("priority", "High");
		issue.put("summary", "This is a fake issue for testing.");
		issue.put("assigned to", "Thomas Thornton");
		return issue;
		
	}
}
