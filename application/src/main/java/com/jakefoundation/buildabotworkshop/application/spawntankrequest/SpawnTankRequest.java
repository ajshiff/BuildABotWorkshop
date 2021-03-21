package com.jakefoundation.buildabotworkshop.application.spawntankrequest;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;

public class SpawnTankRequest {
    private final String username;
    private final String secret;

    public String getUsername() {
        return username;
    }

    public String getSecret() {
        return secret;
    }

    public SpawnTankRequest(Authorization autho) {

        this.username = autho.getUsername();
        this.secret = autho.getPassword();

    }

}
