package com.jakefoundation.buildabotworkshop.application.common;

public class Authorization {
    private final String username;
    private final String password;

    public Authorization(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
