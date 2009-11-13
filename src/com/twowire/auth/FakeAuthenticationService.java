package com.twowire.auth;

public class FakeAuthenticationService implements AuthenticationService {

    public boolean isValidLogin(String user, String pass) {
        return true;
    }
}
