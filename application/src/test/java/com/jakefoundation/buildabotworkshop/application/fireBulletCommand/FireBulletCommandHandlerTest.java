package com.jakefoundation.buildabotworkshop.application.fireBulletCommand;

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;
import com.jakefoundation.buildabotworkshop.domain.Angle;
import com.jakefoundation.buildabotworkshop.domain.FireBulletCommand;
import com.jakefoundation.buildabotworkshop.domain.ShouldDo;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class FireBulletCommandHandlerTest {
    @Test
    public void handleFireBulletCommand_returnsResultSuccess_whenDontSendRequest() {
        IFireBulletCommandService service = mock(IFireBulletCommandService.class);
        FireBulletCommandHandler handler = new FireBulletCommandHandler(service);
        FireBulletCommand command = mock(FireBulletCommand.class);
        when(command.getDoFire()).thenReturn(ShouldDo.dont);
        Authorization auth = mock(Authorization.class);
        ResultStatus result = handler.handleFireBulletCommand(auth, command);
        verify(service, never()).sendFireBulletRequest(any(FireBulletRequest.class));
        Assert.assertEquals(ResultStatus.success, result);
    }

//    @Test
//    public void handleFireBulletCommand_returnsResultSuccess_whenServiceReturnsResultSuccess() {
//        IFireBulletCommandService service = mock(IFireBulletCommandService.class);
//        FireBulletCommandHandler handler = new FireBulletCommandHandler(service);
//        Authorization auth = new Authorization("johndoe", "itsasecret");
//        FireBulletCommand command = new FireBulletCommand(ShouldDo.doit, new Angle(0));
//        when(handler.handleFireBulletCommand(any(Authorization.class), any(FireBulletCommand.class))).thenReturn(ResultStatus.success);
//        ResultStatus result = handler.handleFireBulletCommand(auth, command);
//        Assert.assertEquals(ResultStatus.success, result);
//    }
}