package com.jakefoundation.buildabotworkshop.application.getgamestate;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.domain.GameState;
import com.sun.org.apache.xpath.internal.objects.XObject;

public class GetGameStateQueryHandler {
    private final IGetGameStateService gameStateService;


    /**
     * Another constructor for class GetGameStateQueryHandler
     * @param gameStateService  <to handle the class gameState>
     *
     */
    public GetGameStateQueryHandler(IGetGameStateService gameStateService) {
        this.gameStateService = gameStateService;

    }

    /**
     * This method always returns the gameStateService the new gameState will take.
     *
     * @param  authorization  <the authorization passcode to start the game>
     * @return  the gameStateService
     */
    public GameState getGameState (Authorization authorization){
        GetGameStateRequest getGameStateRequest =  new GetGameStateRequest(authorization);

        return gameStateService.sendGetGameStateRequest(getGameStateRequest);
    }

}
