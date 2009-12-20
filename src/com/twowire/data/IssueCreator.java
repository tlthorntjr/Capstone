package com.twowire.data;

import java.util.Hashtable;

import com.twowire.Observer;
import com.twowire.create.Ticket;

public class IssueCreator implements Observer {
	
	private DataService dataService;
	
	public void update(Ticket ticket) {
		Hashtable issueTable = new Hashtable();
		issueTable.put("summary", "Test");
	    issueTable.put("type", ticket.getTicketType());
	    issueTable.put("assignee", "Tye Robinson");
	    issueTable.put("priority", ticket.getPriority());
	    issueTable.put("project","TST");
	    issueTable.put("description", ticket.getSeverity());
	    dataService = new DataService();
	    dataService.createIssue(issueTable);
	}

}
