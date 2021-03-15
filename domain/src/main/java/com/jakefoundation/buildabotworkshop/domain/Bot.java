package com.jakefoundation.buildabotworkshop.domain;

public interface Bot {

    MoveTankCommand moveCommand(GameState gameState);

    FireBulletCommand fireCommand(GameState gameState);

    String getBotCommonName();

    String getOwnerName();

    String getBotOwnerPassword();

}
