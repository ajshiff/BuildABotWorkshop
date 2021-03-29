package com.jakefoundation.buildabotworkshop.bots;

import com.jakefoundation.buildabotworkshop.domain.Bot;
import com.jakefoundation.buildabotworkshop.domain.FireBulletCommand;
import com.jakefoundation.buildabotworkshop.domain.GameState;
import com.jakefoundation.buildabotworkshop.domain.MoveTankCommand;

import kotlin.NotImplementedError;

public class PamBot implements Bot {

    @Override
    public String getBotCommonName() {
        return "Pam Bot";
    }

    @Override
    public MoveTankCommand moveCommand(GameState gameState) {
        throw new NotImplementedError();
    }

    @Override
    public FireBulletCommand fireCommand(GameState gameState) {
        throw new NotImplementedError();
    }

}
