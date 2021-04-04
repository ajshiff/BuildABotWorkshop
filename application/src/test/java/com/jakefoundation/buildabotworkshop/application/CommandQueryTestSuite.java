package com.jakefoundation.buildabotworkshop.application;

import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.MoveTankCommandHandlerTest;
import com.jakefoundation.buildabotworkshop.application.fireBulletCommand.FireBulletCommandHandlerTest;
import com.jakefoundation.buildabotworkshop.application.getgamestate.GetGameStateQueryHandlerTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Suite.class)

    @Suite.SuiteClasses({
            FireBulletCommandHandlerTest.class,
            MoveTankCommandHandlerTest.class,
            GetGameStateQueryHandlerTest.class
    })
public class CommandQueryTestSuite {
}
