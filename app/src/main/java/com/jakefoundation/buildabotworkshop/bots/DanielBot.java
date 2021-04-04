package com.jakefoundation.buildabotworkshop.bots;

import com.jakefoundation.buildabotworkshop.domain.Angle;
import com.jakefoundation.buildabotworkshop.domain.Bot;
import com.jakefoundation.buildabotworkshop.domain.FireBulletCommand;
import com.jakefoundation.buildabotworkshop.domain.GameState;
import com.jakefoundation.buildabotworkshop.domain.MoveTankCommand;
import com.jakefoundation.buildabotworkshop.domain.ShouldDo;
import com.jakefoundation.buildabotworkshop.domain.Speed;

import kotlin.NotImplementedError;

public class DanielBot implements Bot {

    @Override
    public String getBotCommonName() {
        return "Daniel Bot";
    }

    private Angle angle = new Angle(0.0);
    private int counter = 0;

    @Override
    public MoveTankCommand moveCommand(GameState gameState) {
        if (counter++ % 100 == 0)
            angle = new Angle(angle.getAngleValue() + 10);
        return new MoveTankCommand(ShouldDo.doit, angle, new Speed(10.0));
    }

    @Override
    public FireBulletCommand fireCommand(GameState gameState) {
        return new FireBulletCommand(ShouldDo.dont, new Angle(0.0));
    }

}
