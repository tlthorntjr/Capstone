package com.twowire.web;


import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.twowire.auth.AuthenticationService;
import com.twowire.auth.FakeAuthenticationService;
import com.twowire.auth.LdapAuthenticationService;

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
	
	@Test
	public void testInvalidLoginForwardsToInvalidLoginPage() throws Exception {
		request.addParameter("username", "return");
		request.addParameter("password", "false");
		servlet.service(request, response);
		assertEquals("/InvalidLogin.jsp", response.getRedirectedUrl());
	}
	
	@Test
	public void testGetAuthenticationService() throws Exception {
		boolean fake = servlet.getAuthenticationService().getClass().equals(FakeAuthenticationService.class);
		boolean ldap = servlet.getAuthenticationService().getClass().equals(LdapAuthenticationService.class);
		assertTrue(fake || ldap);
	}
	
	@Test
	public void testDoGetForwardsToDoPost() throws Exception {
		servlet.doGet(request, response);
		assertEquals("/CreateTicket.jsp", response.getRedirectedUrl());
	}

}
