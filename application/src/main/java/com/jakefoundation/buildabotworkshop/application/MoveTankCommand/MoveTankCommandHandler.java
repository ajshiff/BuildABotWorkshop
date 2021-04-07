package com.jakefoundation.buildabotworkshop.application.MoveTankCommand;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;
import com.jakefoundation.buildabotworkshop.domain.MoveTankCommand;
import com.jakefoundation.buildabotworkshop.domain.ShouldDo;

public class MoveTankCommandHandler {


    private final IMoveTankCommandService moveTankCommandService;


    /**
     * Another constructor for class MoveTankCommandHandler
     * @param moveTankCommandService  <handler on the movetankcommand></handler>
     */
    public MoveTankCommandHandler(IMoveTankCommandService moveTankCommandService) {
        this.moveTankCommandService = moveTankCommandService;

    }

    /**
     * method handler to define if the player wins
     * @return ResultStatus if success
     * @param authorization  <the id authorization passcode>
     * @param moveTankCommand  <the handler for the moves command>
     * @return moveTankCommandService if movetankrequest
     */
    public ResultStatus handleMoveTankCommand(Authorization authorization, MoveTankCommand moveTankCommand) {
        if (moveTankCommand.getShouldMove() == ShouldDo.dont) {
            return ResultStatus.success;

        } else {
            MoveTankRequest mike = new MoveTankRequest(authorization, moveTankCommand);
            return moveTankCommandService.sendMoveTankRequest(mike);

        }

    }
}


