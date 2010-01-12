package com.twowire.web.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("TwoWireService")
public interface TwowireService extends RemoteService {
	public void submitIssue(String severity, String ticketType, String priority, boolean notify);
}
