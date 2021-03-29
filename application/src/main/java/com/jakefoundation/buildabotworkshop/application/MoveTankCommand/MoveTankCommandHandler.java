package com.jakefoundation.buildabotworkshop.application.MoveTankCommand;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;
import com.jakefoundation.buildabotworkshop.domain.MoveTankCommand;
import com.jakefoundation.buildabotworkshop.domain.ShouldDo;

public class MoveTankCommandHandler {


    private final IMoveTankCommandService moveTankCommandService;

    public MoveTankCommandHandler(IMoveTankCommandService moveTankCommandService) {
        this.moveTankCommandService = moveTankCommandService;

    }

    public ResultStatus handleMoveTankCommand(Authorization authorization, MoveTankCommand moveTankCommand) {
        if (moveTankCommand.getShouldMove() == ShouldDo.dont) {
            return ResultStatus.success;

        } else {
            MoveTankRequest mike = new MoveTankRequest(authorization, moveTankCommand);
            return moveTankCommandService.sendMoveTankRequest(mike);

        }

    }
}


