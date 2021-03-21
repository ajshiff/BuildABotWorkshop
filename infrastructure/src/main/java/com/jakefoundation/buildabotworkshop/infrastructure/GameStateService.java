package com.jakefoundation.buildabotworkshop.infrastructure;

import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.IMoveTankCommandService;
import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.MoveTankRequest;
import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;
import com.jakefoundation.buildabotworkshop.application.fireBulletCommand.FireBulletRequest;
import com.jakefoundation.buildabotworkshop.application.fireBulletCommand.IFireBulletCommandService;
import com.jakefoundation.buildabotworkshop.application.getgamestate.GetGameStateRequest;
import com.jakefoundation.buildabotworkshop.application.getgamestate.IGetGameStateService;
import com.jakefoundation.buildabotworkshop.domain.GameState;
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation.LocalGameCalculator;

public class GameStateService implements IFireBulletCommandService, IGetGameStateService, IMoveTankCommandService {

    private final LocalGameCalculator gameCalc;

    public GameStateService (LocalGameCalculator gameCalc) {
        this.gameCalc = gameCalc;
    }

    @Override
    public ResultStatus sendMoveTankRequest(MoveTankRequest moveTankRequest) {
        return ResultStatus.failure;
    }

    @Override
    public ResultStatus sendFireBulletRequest(FireBulletRequest fireBulletRequest) {
        return ResultStatus.failure;
    }

    @Override
    public GameState sendGetGameStateRequest(GetGameStateRequest getGameStateRequest) {
        return null;
    }
}