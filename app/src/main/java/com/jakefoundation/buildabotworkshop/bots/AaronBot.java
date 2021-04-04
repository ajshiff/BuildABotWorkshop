package com.jakefoundation.buildabotworkshop.bots;

import com.jakefoundation.buildabotworkshop.domain.Angle;
import com.jakefoundation.buildabotworkshop.domain.Bot;
import com.jakefoundation.buildabotworkshop.domain.FireBulletCommand;
import com.jakefoundation.buildabotworkshop.domain.GameState;
import com.jakefoundation.buildabotworkshop.domain.MoveTankCommand;
import com.jakefoundation.buildabotworkshop.domain.ShouldDo;
import com.jakefoundation.buildabotworkshop.domain.Speed;

public class AaronBot implements Bot {

    @Override
    public String getBotCommonName() {
        return "Aaron Bot";
    }

    @Override
    public MoveTankCommand moveCommand(GameState gameState) {
        return new MoveTankCommand(ShouldDo.doit, new Angle(0.0), new Speed(10.0));
    }

    @Override
    public FireBulletCommand fireCommand(GameState gameState) {
        return new FireBulletCommand(ShouldDo.doit, new Angle(45.0));
    }

}
