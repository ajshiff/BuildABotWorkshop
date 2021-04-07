package com.jakefoundation.buildabotworkshop.application.spawntankrequest;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;

public class SpawnTankRequest {
    private final String username;
    private final String secret;

    /**
     * @return the username
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
     * Another constructor for class SpawnTankRequest
     * @param autho  <the id authorization>
     *
     */
    public SpawnTankRequest(Authorization autho) {

        this.username = autho.getUsername();
        this.secret = autho.getPassword();

    }

}
