package com.jakefoundation.buildabotworkshop.application.MoveTankCommand;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;
import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.MoveTankCommandHandler;
import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.IMoveTankCommandService;
import com.jakefoundation.buildabotworkshop.domain.Angle;
import com.jakefoundation.buildabotworkshop.domain.MoveTankCommand;
import com.jakefoundation.buildabotworkshop.domain.MoveTankCommand;
import com.jakefoundation.buildabotworkshop.domain.ShouldDo;
import com.jakefoundation.buildabotworkshop.domain.Speed;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoveTankCommandHandlerTest {
    @Test
    public void handleMoveTankCommand_returnsResultSuccess_whenDontSendRequest() {
        IMoveTankCommandService service = mock(IMoveTankCommandService.class);
        MoveTankCommandHandler handler = new MoveTankCommandHandler(service);
        MoveTankCommand command = mock(MoveTankCommand.class);
        when(command.getShouldMove()).thenReturn(ShouldDo.dont);
        Authorization auth = mock(Authorization.class);
        ResultStatus result = handler.handleMoveTankCommand(command, auth);
        verify(service, never()).sendMoveTankRequest(any(MoveTankRequest.class));
        Assert.assertEquals(ResultStatus.success, result);
    }

//    @Test
//    public void handleMoveTankCommand_returnsResultSuccess_whenServiceReturnsResultSuccess() {
//        IMoveTankCommandService service = mock(IMoveTankCommandService.class);
//        MoveTankCommandHandler handler = new MoveTankCommandHandler(service);
//        Authorization auth = new Authorization("johndoe", "itsasecret");
//        MoveTankCommand command = new MoveTankCommand(ShouldDo.doit, new Angle(0), new Speed(0));
//        when(handler.handleMoveTankCommand(any(MoveTankCommand.class), any(Authorization.class))).thenReturn(ResultStatus.success);
//        ResultStatus result = handler.handleMoveTankCommand(command, auth);
//        Assert.assertEquals(ResultStatus.success, result);
//    }
}