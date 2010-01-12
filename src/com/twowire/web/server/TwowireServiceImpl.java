package com.twowire.web.server;

import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.twowire.create.TicketFactory;
import com.twowire.model.PendingTickets;
import com.twowire.web.client.TwowireService;

@SuppressWarnings("serial")
public class TwowireServiceImpl extends RemoteServiceServlet implements
		TwowireService {
	
	private TicketFactory factory;
	private PendingTickets issues;
	
	public TwowireServiceImpl() {
		factory = new TicketFactory();
		issues = new PendingTickets();
	}
	
	@Override
	public void submitIssue(String severity, String ticketType,
			String priority, boolean notify) {
		
		factory.createTicket(severity, ticketType, priority, null, true);
	
	}

	@Override
	public List<String> retrieveIssues() {
		return issues.getTickets();
	}

}
