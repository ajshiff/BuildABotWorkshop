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
    /**
     * Another constructor for class Player
     * @param auth  <the id authorization passcode>
     * @param bot  <the bot chosen>
     * @param color  <the color chosen>
     */
    public Player(Authorization auth,
                  Bot bot,
                  TankColors color) {
        this.auth = auth;
        this.bot = bot;
        this.color = color;
    }

    /**
     * @return the bot chosen
     */
    public Bot getBot() {
        return bot;
    }

    /**
     * @return the authorization id passcode
     */
    public Authorization getAuth() {
        return auth;
    }


    /**
     * @return the color chosen
     */
    public TankColors getColor() {
        return color;
    }

    /**
     * @return the details on the bot
     */
    public Unit getSelfDetails() { return selfDetails; }

    /**
     *
     * @param unit to set the details on the bot
     */
    public void setSelfDetails(Unit unit) { selfDetails = unit; }
}
