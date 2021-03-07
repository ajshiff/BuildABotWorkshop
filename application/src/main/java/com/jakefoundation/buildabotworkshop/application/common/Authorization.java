package com.jakefoundation.buildabotworkshop.application.common;

public class Authorization {
    private final String username;
    private final String password;


    public Authorization(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
