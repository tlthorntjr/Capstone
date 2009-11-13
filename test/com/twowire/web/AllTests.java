package com.twowire.web;

import com.twowire.auth.TestLdapAuthenticationService;
import com.twowire.data.TestDataService;
import com.twowire.data.TestXmlRpcConfiguration;
import com.twowire.data.TestXmlRpcDataConnection;
import com.twowire.model.TestUser;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.twowire.web");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestLoginController.class);
		suite.addTestSuite(TestCreateTicketController.class);
		suite.addTestSuite(TestDataService.class);
		suite.addTestSuite(TestXmlRpcConfiguration.class);
		suite.addTestSuite(TestUser.class);
		suite.addTestSuite(TestLdapAuthenticationService.class);
		suite.addTestSuite(TestXmlRpcDataConnection.class);
		//$JUnit-END$
		return suite;
	}

}
