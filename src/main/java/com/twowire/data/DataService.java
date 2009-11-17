package com.twowire.data;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;


public class DataService implements IDataService {
    
    private DataConnection conn;
    
    public DataService(DataConnection conn) {
    	this.conn = conn;
    }

	public DataService() {
		this.conn = new XmlRpcDataConnection();
	}

	public HashMap<?, ?> retrieveIssue(String loginToken, String issueKey) throws XmlRpcException {
		List<String> getIssueParams = new Vector<String>(2);
		getIssueParams.add(loginToken);
		getIssueParams.add(issueKey);
		DataConfiguration config = conn.getConfig();
		HashMap<?, ?> issue = (HashMap<?, ?>) config.getClient().execute("jira1.getIssue", getIssueParams);
		return issue;
	}

}
