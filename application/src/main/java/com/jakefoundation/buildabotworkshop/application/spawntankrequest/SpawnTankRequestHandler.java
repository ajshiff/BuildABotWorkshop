package com.jakefoundation.buildabotworkshop.application.spawntankrequest;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;
import com.jakefoundation.buildabotworkshop.domain.GameState;

public class SpawnTankRequestHandler {
    private final ISpawnTankService gameStateService;


    /**
     * Another constructor for class SpawnTankRequestHandler
     * @param gameStateService  <handler on the SpawnTankRequestHandler></handler>
     */
    public SpawnTankRequestHandler(ISpawnTankService gameStateService) {
        this.gameStateService = gameStateService;

    }


    /**
     * method handler to create tanks
     * @return gameStateService if sendSpawnTankRequest(spawnTankRequest)
     * @param authorization  <the id authorization passcode>
     */
    public ResultStatus handleSpawnTankCommand(Authorization authorization){
        SpawnTankRequest spawnTankRequest = new SpawnTankRequest(authorization);

        return gameStateService.sendSpawnTankRequest(spawnTankRequest);
    }

}
