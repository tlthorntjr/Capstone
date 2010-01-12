package com.twowire.web.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TwowireServiceAsync {

	void submitIssue(String severity, String ticketType, String priority,
			boolean notify, AsyncCallback<Void> callback);

}
