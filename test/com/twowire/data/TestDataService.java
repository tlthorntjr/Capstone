package com.twowire.data;

import java.util.HashMap;

import junit.framework.TestCase;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.junit.Before;

public class TestDataService extends TestCase {
	
	private DataConfiguration dataConfig;
	private DataService dataService;
	
	@Before
	public void setUp() throws Exception {
		dataConfig = new XmlRpcConfiguration() {
			@Override
			public XmlRpcClient getClient() {
				return new FakeXmlRpcClient();
			}
		};
		dataService = new DataService(new XmlRpcDataConnection(dataConfig));
	}
	
	public void testRetrieveIssue() throws Exception {
		HashMap issue = dataService.retrieveIssue("Shouldnt Matter", "Made Up");
		assertEquals(issue.get("priority"), "High");
		assertEquals(issue.get("summary"), "This is a fake issue for testing.");
		assertEquals(issue.get("assigned to"), "Thomas Thornton");
	}

}
