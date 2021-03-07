package com.jakefoundation.buildabotworkshop.application.getgamestate;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.domain.GameState;
import com.sun.org.apache.xpath.internal.objects.XObject;

public class GetGameStateHandler {
    private final IGetGameStateService gameStateService;

    public GetGameStateHandler(IGetGameStateService gameStateService) {
        this.gameStateService = gameStateService;

    }

    public GameState getGameState (Authorization authorization){
        GetGameStateRequest getGameStateRequest =  new GetGameStateRequest(authorization);

        return gameStateService.sendGetGameStateRequest(getGameStateRequest);
    }

}
