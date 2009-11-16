package com.twowire.create;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class TestTicketFactory extends TestCase {

	@Before
	public void setUp() throws Exception {
		TicketFactory factory = new TicketFactory();
		factory.createTicket("test_severity", "test_ticket_type", "p1", null, true);
	}
	
	@Test
	public void testCreateTicket() throws Exception {
		//this class will need to be mocked for successful testing
	}
}
