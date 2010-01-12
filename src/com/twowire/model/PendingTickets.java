package com.twowire.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.twowire.data.jira.DataService;
import com.twowire.data.jira.IDataService;

public class PendingTickets {
	
	@SuppressWarnings("unused")
	private IDataService dataService;
	
	public PendingTickets() {
		this.dataService = new DataService();
	}
	public PendingTickets(IDataService dataService) {
		this.dataService = dataService;
	}

	@SuppressWarnings("unchecked")
	public List<String> getTickets() {
		List<String> result = new ArrayList<String>();
		result.add("Issue: 1; Priority: Minor; Type: Bug;");
		result.add("Issue: 2; Priority: Stopper; Type: Feature;");
		result.add("Issue: 3; Priority: Critical; Type: Improvement;");
		result.add("Issue: 4; Priority: Major; Type: Bug;");
		return result;
	}

}
