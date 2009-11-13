package com.twowire.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.twowire.data.DataService;

import junit.framework.TestCase;

public class TestPendingTickets extends TestCase {
	
	@Test
	public void testSetGetTickets() throws Exception {
		PendingTickets tickets = new PendingTickets(new DataService());
		tickets.setTickets(null);
		assertEquals(tickets.getTickets().get(0), "I am a test ticket");
	}
}
