package com.jakefoundation.buildabotworkshop.application.MoveTankCommand;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.domain.MoveTankCommand;

public class MoveTankRequest {

    private final String username;
    private final String secret;
    private final double angle;
    private final double speed;
    public MoveTankRequest(Authorization auth, MoveTankCommand moveTankCommand) {

        username = auth.getUsername();
        secret = auth.getUsername();
        angle = moveTankCommand.getDirection().getAngleValue();
        speed = moveTankCommand.getSpeed().getValue();
    }


    public String getUsername() {
        return username;
    }

    public String getSecret() {
        return secret;
    }

    public double getAngle() {
        return angle;
    }

    public double getSpeed() {
        return speed;
    }
}
