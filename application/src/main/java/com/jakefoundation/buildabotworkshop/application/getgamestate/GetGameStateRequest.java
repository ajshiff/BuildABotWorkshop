package com.jakefoundation.buildabotworkshop.application.getgamestate;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;

public class GetGameStateRequest {
    private final String username;
    private final String secret;

    /**
     * @return the username id
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the secret password
     */
    public String getSecret() {
        return secret;
    }


    /**
     * Another constructor for class GetGameStateRequest
     * @param autho  <the id authorization>
     *
     */

    public GetGameStateRequest(Authorization autho) {

        this.username = autho.getUsername();
        this.secret = autho.getPassword();

    }

}
