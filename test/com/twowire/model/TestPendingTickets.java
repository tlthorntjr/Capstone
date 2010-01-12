package com.twowire.model;

import org.junit.Test;

import com.twowire.data.jira.DataService;

import junit.framework.TestCase;

public class TestPendingTickets extends TestCase {
	
	@Test
	public void testSetGetTickets() throws Exception {
		PendingTickets tickets = new PendingTickets(new DataService());
		assertEquals(tickets.getTickets().get(0).get("priority"), "High");
	}
}
