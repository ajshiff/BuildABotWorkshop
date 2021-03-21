package com.jakefoundation.buildabotworkshop.application.spawntankrequest;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.domain.GameState;

public class SpawnTankRequestHandler {
    private final ISpawnTankService gameStateService;

    public SpawnTankRequestHandler(ISpawnTankService gameStateService) {
        this.gameStateService = gameStateService;

    }

    public GameState getGameState (Authorization authorization){
        SpawnTankRequest spawnTankRequest = new SpawnTankRequest(authorization);

        return gameStateService.sendGetGameStateRequest(spawnTankRequest);
    }

}
