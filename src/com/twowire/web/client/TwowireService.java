package com.twowire.web.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("TwoWireService")
public interface TwowireService extends RemoteService {
	public void submitIssue(String severity, String ticketType, String priority, boolean notify);
	public List<String> retrieveIssues();
}
