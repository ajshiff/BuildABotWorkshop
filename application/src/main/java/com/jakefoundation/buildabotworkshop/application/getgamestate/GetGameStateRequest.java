package com.jakefoundation.buildabotworkshop.application.getgamestate;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;

public class GetGameStateRequest {
    private final String username;
    private final String secret;

    public String getUsername() {
        return username;
    }

    public String getSecret() {
        return secret;
    }

    public GetGameStateRequest(Authorization autho) {

        this.username = autho.getUsername();
        this.secret = autho.getPassword();

    }

}
