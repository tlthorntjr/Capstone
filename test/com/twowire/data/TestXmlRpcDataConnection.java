package com.twowire.data;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class TestXmlRpcDataConnection extends TestCase {

	private XmlRpcDataConnection conn;
	
	@Before
	public void setUp() throws Exception {
		conn = new XmlRpcDataConnection();
	}
	
	@Test
	public void testLogoutInvalidLoginToken() throws Exception {
		boolean result = conn.logout("Logging out now...");
		assertFalse(result);
	}

	//this test will need to use the FakeClient because execute returns
	//a different string each time and we don't want to make a call to 
	//jira for each access
	@Test
	public void testLoginReturnsValidLoginToken() throws Exception {
//		String result = conn.login();
//		assertEquals(result, "6dN8VL2Nle");
	}
	
// this currently requires server access, mock out
	@Test
	public void testLogoutValidToken() throws Exception {
		String loginToken = conn.login();
		boolean result = conn.logout(loginToken);
		assertTrue(result);
	}

}
