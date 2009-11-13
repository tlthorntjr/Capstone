package com.twowire.web;


import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.twowire.auth.AuthenticationService;
import com.twowire.auth.FakeAuthenticationService;

public class TestLoginController extends TestCase {
	
	private static final String VALID_USERNAME = "validuser";
	private static final String CORRECT_PASSWORD = "validpassword";
	
	private LoginController servlet;
	private FakeAuthenticationService authenticator;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	
	@Before
	public void setUp() throws Exception {
		authenticator = new FakeAuthenticationService();
		
		servlet = new LoginController() {
			@Override
			protected AuthenticationService getAuthenticationService() {
				return authenticator;
			}
		};
		
		request = new MockHttpServletRequest("POST", "/login");
		response = new MockHttpServletResponse();
	}
	
	@Test
	public void testLoginRedirect() throws Exception {
		servlet.service(request, response);
		assertEquals("/CreateTicket.jsp", response.getRedirectedUrl());
	}

	@Test
	public void testValidLoginForwardsToFrontPageAndStoresUserName() throws Exception {
		request.addParameter("username", VALID_USERNAME);
		request.addParameter("password", CORRECT_PASSWORD);
		servlet.service(request, response);
		assertEquals("/CreateTicket.jsp", response.getRedirectedUrl());
		assertEquals("validuser", request.getSession().getAttribute("username"));
	}

}
