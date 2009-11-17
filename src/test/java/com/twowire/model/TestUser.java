package com.twowire.model;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class TestUser extends TestCase {
	
	private User user;
	
	@Before
	public void setUp() throws Exception {
		user = new User();
	}
	
	@Test
	public void testPassword() throws Exception {
		user.setPassword("pass");
		assertEquals("pass", user.getPassword());
	}

	@Test
	public void testUsername() throws Exception {
		user.setUsername("user");
		assertEquals("user", user.getUsername());
	}
}
