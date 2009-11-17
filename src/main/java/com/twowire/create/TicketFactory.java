package com.twowire.create;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.twowire.Observer;
import com.twowire.Subject;
import com.twowire.data.IssueCreator;
import com.twowire.notify.EmailNotification;

public class TicketFactory implements Subject {
	
	private List<Observer> observers;
	
	public TicketFactory() {
		observers = new ArrayList<Observer>();
		observers.add(new EmailNotification());
		observers.add(new IssueCreator());
	}
	
	public void createTicket(String severity, String ticketType, String priority, File attachment, boolean notify) {
		notifyObservers(new Ticket(severity, ticketType, priority, attachment, notify));
	}
	
	public void notifyObservers(Ticket ticket) {
		for (Iterator<Observer> it = observers.iterator(); it.hasNext();) {
			Observer observer = (Observer) it.next();
			observer.update(ticket);
		}
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

}
