package com.twowire.auth;

public interface AuthenticationService {
	boolean isValidLogin(String username, String password);
}
