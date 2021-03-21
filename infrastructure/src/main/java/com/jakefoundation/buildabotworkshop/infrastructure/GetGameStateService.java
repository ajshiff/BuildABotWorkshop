package com.jakefoundation.buildabotworkshop.infrastructure;

import com.jakefoundation.buildabotworkshop.application.getgamestate.GetGameStateRequest;
import com.jakefoundation.buildabotworkshop.application.getgamestate.IGetGameStateService;
import com.jakefoundation.buildabotworkshop.domain.GameState;

public class GetGameStateService implements IGetGameStateService {
    @Override
    public GameState sendGetGameStateRequest(GetGameStateRequest getGameStateRequest) {
        return null;
    }
}
