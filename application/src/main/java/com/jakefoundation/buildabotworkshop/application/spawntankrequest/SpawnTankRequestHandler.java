package com.jakefoundation.buildabotworkshop.application.spawntankrequest;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;
import com.jakefoundation.buildabotworkshop.domain.GameState;

public class SpawnTankRequestHandler {
    private final ISpawnTankService gameStateService;

    public SpawnTankRequestHandler(ISpawnTankService gameStateService) {
        this.gameStateService = gameStateService;

    }

    public ResultStatus getGameState (Authorization authorization){
        SpawnTankRequest spawnTankRequest = new SpawnTankRequest(authorization);

        return gameStateService.sendSpawnTankRequest(spawnTankRequest);
    }

}
