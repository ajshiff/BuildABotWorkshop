package com.jakefoundation.buildabotworkshop.application.common;

public class Authorization {
    private final String username;
    private final String password;

    /**
     * Another constructor for class Authorization
     * @param username   <the id authorization passcode>
     * @param password   <the bot chosen>

     */
    public Authorization(String username, String password) {
        this.username = username;
        this.password = password;
    }
    /**
     * @return the username id
     */
    public String getUsername() {
        return username;
    }


    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
