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

    /**
     * This method always returns the new bot with the new values.
     *
     * @param  gameState  a class where the states of the game are based
     * @return      the new bot
     */
    @Override
    public MoveTankCommand moveCommand(GameState gameState) {
        return new MoveTankCommand(ShouldDo.doit, new Angle(180.0), new Speed(10.0));
    }

    /**
     * This method always returns the fire commands the new bot will take.
     *
     * @param  gameState  a class where the states of the game are based
     * @return      the new bot fire commands
     */
    @Override
    public FireBulletCommand fireCommand(GameState gameState) {
        return new FireBulletCommand(ShouldDo.doit, new Angle(78.0));
    }

}
