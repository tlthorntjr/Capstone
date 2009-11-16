package com.twowire.web;


import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.twowire.create.Ticket;

public class TestCreateTicketController extends TestCase {

	private CreateTicketController servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	
	@Before
	public void setUp() throws Exception {
		request = new MockHttpServletRequest("POST", "/login.do");
		response = new MockHttpServletResponse();
		servlet = new CreateTicketController();
	}
	
	@Test
	public void testSuccessfulTicketRedirect() throws Exception {
		request.addParameter("subject", "testSubject");
		request.addParameter("question", "testQuestion");
		request.addParameter("category", "testCategory");
		request.addParameter("submit_question", "submit");
		servlet.service(request, response);
		assertEquals("/Success.jsp", response.getRedirectedUrl());
	}

	@Test
	public void testMissingFieldFailRedirect() throws Exception {
		request.addParameter("subject", "testSubject");
		request.addParameter("question", "testQuestion");
		servlet.service(request, response);
		assertEquals("/CreateTicket.jsp", response.getRedirectedUrl());
	}

}
