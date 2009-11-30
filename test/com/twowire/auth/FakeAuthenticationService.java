package com.twowire.auth;

public class FakeAuthenticationService implements AuthenticationService {

	
    public boolean isValidLogin(String user, String pass) {
        if(user == null) {
        	return true;
        }
    	if(user.equals("return") && pass.equals("false")) {
        	return false;
        }
    	return true;
    }
}
