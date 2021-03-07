package com.jakefoundation.buildabotworkshop.application.getgamestate;

import com.jakefoundation.buildabotworkshop.domain.GameState;

public interface IGetGameStateService {
     GameState sendGetGameStateRequest (GetGameStateRequest getGameStateRequest);
}
