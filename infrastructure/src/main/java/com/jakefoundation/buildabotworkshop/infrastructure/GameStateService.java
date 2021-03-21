package com.jakefoundation.buildabotworkshop.infrastructure;

import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.IMoveTankCommandService;
import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.MoveTankRequest;
import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;
import com.jakefoundation.buildabotworkshop.application.fireBulletCommand.FireBulletRequest;
import com.jakefoundation.buildabotworkshop.application.fireBulletCommand.IFireBulletCommandService;
import com.jakefoundation.buildabotworkshop.application.getgamestate.GetGameStateRequest;
import com.jakefoundation.buildabotworkshop.application.getgamestate.IGetGameStateService;
import com.jakefoundation.buildabotworkshop.application.spawntankrequest.ISpawnTankService;
import com.jakefoundation.buildabotworkshop.application.spawntankrequest.SpawnTankRequest;
import com.jakefoundation.buildabotworkshop.domain.GameState;
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation.LocalGameStateRequestHandler;

public class GameStateService implements IFireBulletCommandService, IGetGameStateService, IMoveTankCommandService, ISpawnTankService {

    private final LocalGameStateRequestHandler gameCalc;

    public GameStateService (LocalGameStateRequestHandler gameCalc) {
        this.gameCalc = gameCalc;
    }

    @Override
    public ResultStatus sendSpawnTankRequest(SpawnTankRequest spawnTankRequest) {
        gameCalc.receiveSpawnTankRequest(spawnTankRequest);
        return ResultStatus.failure;
    }

    @Override
    public ResultStatus sendMoveTankRequest(MoveTankRequest moveTankRequest) {
        gameCalc.receiveMoveCommand(moveTankRequest);
        return ResultStatus.failure;
    }

    @Override
    public ResultStatus sendFireBulletRequest(FireBulletRequest fireBulletRequest) {
        gameCalc.receiveFireCommand(fireBulletRequest);
        return ResultStatus.failure;
    }

    @Override
    public GameState sendGetGameStateRequest(GetGameStateRequest getGameStateRequest) {
        gameCalc.receiveGetGameStateRequest(getGameStateRequest);
        return null;
    }
}