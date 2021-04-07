package com.jakefoundation.buildabotworkshop.application.MoveTankCommand;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.domain.MoveTankCommand;

public class MoveTankRequest {

    private final String username;
    private final String secret;
    private final double angle;
    private final double speed;

    /**
     * Another constructor for class MoveTankRequest
     * @param auth  <the id authorization>
     * @param moveTankCommand  <the handler for the moves command>
     *
     */
    public MoveTankRequest(Authorization auth, MoveTankCommand moveTankCommand) {

        username = auth.getUsername();
        secret = auth.getUsername();
        angle = moveTankCommand.getDirection().getAngleValue();
        speed = moveTankCommand.getSpeed().getValue();
    }

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
     * @return the angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }
}
