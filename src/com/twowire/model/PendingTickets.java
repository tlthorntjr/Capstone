package com.twowire.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.twowire.data.IDataService;

public class PendingTickets {
	
	private List tickets;
	private IDataService dataService;
	
	public PendingTickets(IDataService dataService) {
		this.dataService = dataService;
	}

	public List<HashMap> getTickets() {
		List result = new ArrayList();
		HashMap issue = new HashMap();
		issue.put("priority", "High");
		issue.put("summary", "This is a fake issue for testing.");
		issue.put("assigned to", "Thomas Thornton");
		result.add(issue);
		HashMap issue2 = new HashMap();
		issue.put("priority", "Medium");
		issue.put("summary", "blah blah I have a problem blah.");
		issue.put("assigned to", "Thomas Thornton");
		result.add(issue2);
		HashMap issue3 = new HashMap();
		issue.put("priority", "High");
		issue.put("summary", "Problem Problem Problem.");
		issue.put("assigned to", "Thomas Thornton");
		result.add(issue3);
		return result;
	}

}
