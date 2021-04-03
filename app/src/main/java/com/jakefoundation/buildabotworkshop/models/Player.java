package com.jakefoundation.buildabotworkshop.models;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.domain.Bot;
import com.jakefoundation.buildabotworkshop.domain.unit.Unit;

public class Player {
    private final Bot bot;
    private final TankColors color;
    private final Authorization auth;
    private Unit selfDetails;

    public Player(Authorization auth,
                  Bot bot,
                  TankColors color) {
        this.auth = auth;
        this.bot = bot;
        this.color = color;
    }

    public Bot getBot() {
        return bot;
    }

    public Authorization getAuth() {
        return auth;
    }

    public TankColors getColor() {
        return color;
    }

    public Unit getSelfDetails() { return selfDetails; }

    public void setSelfDetails(Unit unit) { selfDetails = unit; }
}
