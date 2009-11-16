package com.twowire.notify;


import java.io.File;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.twowire.create.Ticket;

public class TestGeneralNotification extends TestCase {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testClass() throws Exception {
		GeneralNotification gn = new GeneralNotification();
		gn.update(new Ticket("Blah", "Blah", "Blah", new File("blah.txt"), false));
	}

}
