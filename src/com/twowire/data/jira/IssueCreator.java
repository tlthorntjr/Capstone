package com.twowire.data.jira;

import java.util.Hashtable;

import com.twowire.Observer;
import com.twowire.create.Ticket;

public class IssueCreator implements Observer {
	
	private DataService dataService;
	
	public void update(Ticket ticket) {
		Hashtable issueTable = new Hashtable();
		issueTable.put("summary", "Test issue created from dev environment.");
	    issueTable.put("type", 2);
// Type must be an int from 2-5 (maybe 1 and 6?) we'll have to look into the significance of the numbers
	    issueTable.put("assignee", ""); //unassigned
//	    issueTable.put("priority", ticket.getPriority());
	    issueTable.put("project","TST");
	    issueTable.put("description", ticket.getSeverity());
	    dataService = new DataService();
	    dataService.createIssue(issueTable);
	}

}
