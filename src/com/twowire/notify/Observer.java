package com.twowire.notify;

import com.twowire.model.Ticket;

public interface Observer {
	public void update(Ticket ticket);
}
