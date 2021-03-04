package com.jakefoundation.buildabotworkshop.domain;

public interface Bot {

    MoveTankRequest moveCommand(GameState gameState);

    FireBulletRequest fireCommand(GameState gameState);

    String getBotCommonName();

    String getOwnerName();

    String getBotOwnerPassword();

}
