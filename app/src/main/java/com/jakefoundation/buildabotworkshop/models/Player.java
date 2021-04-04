package com.jakefoundation.buildabotworkshop.models;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.domain.Angle;
import com.jakefoundation.buildabotworkshop.domain.Bot;
import com.jakefoundation.buildabotworkshop.domain.HitPoints;
import com.jakefoundation.buildabotworkshop.domain.Owner;
import com.jakefoundation.buildabotworkshop.domain.Position;
import com.jakefoundation.buildabotworkshop.domain.Speed;
import com.jakefoundation.buildabotworkshop.domain.unit.Unit;
import com.jakefoundation.buildabotworkshop.domain.unit.UnitType;

public class Player {
    private final Bot bot;
    private final TankColors color;
    private final Authorization auth;
    private Unit selfDetails = new Unit(UnitType.tank,
            new Position(0.0, 0.0),
            new Angle(0.0),
            new Speed(0.0),
            new HitPoints(1),
            new Owner("default"));

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
