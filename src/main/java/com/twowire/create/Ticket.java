package com.twowire.create;

import java.io.File;

public class Ticket {
	
	private String severity;
	private String ticketType;
	private String priority;
	private File attachment;
	private boolean notify;

	public Ticket(String severity, String ticketType, String priority, File attachment, boolean notify) {
		this.severity = severity;
		this.ticketType = ticketType;
		this.priority = priority;
		this.attachment = attachment;
		this.notify = notify;
	}

}
