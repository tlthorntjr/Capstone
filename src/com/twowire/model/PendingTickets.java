package com.twowire.model;

import java.util.ArrayList;
import java.util.List;

import com.twowire.data.IDataService;

public class PendingTickets {
	
	private List tickets;
	private IDataService dataService;
	
	public PendingTickets(IDataService dataService) {
		this.dataService = dataService;
	}
	
	public void setTickets(List tickets) {
		this.tickets = tickets;
	}

	public List getTickets() {
		List result = new ArrayList();
		result.add("I am a test ticket");
		result.add("I am also a test ticket");
		return result;
	}

}
