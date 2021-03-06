package com.jakefoundation.buildabotworkshop.application.MoveTankCommand;

import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;

public interface IMoveTankCommandService {
    public ResultStatus sendMoveTankRequest(MoveTankRequest moveTankRequest);

}
