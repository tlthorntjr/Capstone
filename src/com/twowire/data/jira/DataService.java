package com.twowire.data.jira;

import java.util.HashMap;
import java.util.Hashtable;
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

	public void createIssue(Hashtable issueTable) {
		Vector createIssueParams = new Vector();
		String loginToken = conn.login();
		createIssueParams.add(loginToken);
		createIssueParams.add(issueTable);
		try {
			conn.getConfig().getClient().execute("jira1.createIssue", createIssueParams);
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}
	}

}
