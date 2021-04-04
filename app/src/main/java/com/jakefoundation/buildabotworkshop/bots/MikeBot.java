package com.jakefoundation.buildabotworkshop.bots;

import com.jakefoundation.buildabotworkshop.domain.Angle;
import com.jakefoundation.buildabotworkshop.domain.Bot;
import com.jakefoundation.buildabotworkshop.domain.FireBulletCommand;
import com.jakefoundation.buildabotworkshop.domain.GameState;
import com.jakefoundation.buildabotworkshop.domain.MoveTankCommand;
import com.jakefoundation.buildabotworkshop.domain.ShouldDo;
import com.jakefoundation.buildabotworkshop.domain.Speed;

import kotlin.NotImplementedError;

public class MikeBot implements Bot {

    @Override
    public String getBotCommonName() {
        return "Mike Bot";
    }

    @Override
    public MoveTankCommand moveCommand(GameState gameState) {
        return new MoveTankCommand(ShouldDo.doit, new Angle(180.0), new Speed(10.0));
    }

    @Override
    public FireBulletCommand fireCommand(GameState gameState) {
        return new FireBulletCommand(ShouldDo.dont, new Angle(0.0));
    }

}
