package com.twowire.web.client;

import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TwowireServiceAsync {

	void submitIssue(String severity, String ticketType, String priority,
			boolean notify, AsyncCallback<Void> callback);

	void retrieveIssues(AsyncCallback<List<String>> asyncCallback);

}
