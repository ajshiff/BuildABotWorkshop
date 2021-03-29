package com.jakefoundation.buildabotworkshop.domain;

public interface Bot {

    String getBotCommonName();

    MoveTankCommand moveCommand(GameState gameState);

    FireBulletCommand fireCommand(GameState gameState);

}
