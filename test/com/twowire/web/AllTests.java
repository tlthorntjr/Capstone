package com.twowire.web;

import com.twowire.auth.TestLdapAuthenticationService;
import com.twowire.data.TestDataService;
import com.twowire.data.TestXmlRpcConfiguration;
import com.twowire.data.TestXmlRpcDataConnection;
import com.twowire.model.TestPendingTickets;
import com.twowire.model.TestUser;
import com.twowire.notify.TestEmailNotification;
import com.twowire.notify.TestGeneralNotification;
import com.twowire.notify.TestSMSNotification;

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
		suite.addTestSuite(TestEmailNotification.class);
		suite.addTestSuite(TestGeneralNotification.class);
		suite.addTestSuite(TestSMSNotification.class);
		suite.addTestSuite(TestPendingTickets.class);
		//$JUnit-END$
		return suite;
	}

}
