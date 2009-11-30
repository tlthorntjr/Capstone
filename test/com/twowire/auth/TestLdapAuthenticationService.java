package com.twowire.auth;

import junit.framework.TestCase;

import org.junit.Test;


public class TestLdapAuthenticationService extends TestCase {
	
	@Test
	public void testLdapNotImplemented() throws Exception {
		LdapAuthenticationService service = new LdapAuthenticationService();
		assertFalse(service.isValidLogin("blah", "blah"));
	}
}
