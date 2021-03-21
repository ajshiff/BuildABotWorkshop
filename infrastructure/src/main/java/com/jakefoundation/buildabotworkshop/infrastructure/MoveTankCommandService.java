package com.jakefoundation.buildabotworkshop.infrastructure;

import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.IMoveTankCommandService;
import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.MoveTankRequest;
import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;

public class MoveTankCommandService implements IMoveTankCommandService {

    @Override
    public ResultStatus sendMoveTankRequest(MoveTankRequest moveTankRequest) {
        return ResultStatus.failure;
    }
}
