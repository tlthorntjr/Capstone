package com.twowire.model;

public class Ticket {
	
	private String subject;
	private String question;
	private String category;

	public Ticket(String subject, String question, String category) {
		this.subject = subject;
		this.question = question;
		this.category = category;
	}

	public String getSubject() {
		return subject;
	}

}
