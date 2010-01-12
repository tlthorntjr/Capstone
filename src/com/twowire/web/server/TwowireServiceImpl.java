package com.twowire.web.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.twowire.create.TicketFactory;
import com.twowire.web.client.TwowireService;

@SuppressWarnings("serial")
public class TwowireServiceImpl extends RemoteServiceServlet implements
		TwowireService {
	
	TicketFactory factory = new TicketFactory();
	
	@Override
	public void submitIssue(String severity, String ticketType,
			String priority, boolean notify) {
		
		factory.createTicket(severity, ticketType, priority, null, true);
	
	}

}
