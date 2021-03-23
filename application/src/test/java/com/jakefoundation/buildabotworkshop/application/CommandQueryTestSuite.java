package com.jakefoundation.buildabotworkshop.application;

import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.MoveTankCommandHandlerTest;
import com.jakefoundation.buildabotworkshop.application.fireBulletCommand.FireBulletCommandHandlerTest;
import com.jakefoundation.buildabotworkshop.application.getgamestate.GetGameStateHandlerTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Suite.class)

    @Suite.SuiteClasses({
            FireBulletCommandHandlerTest.class,
            MoveTankCommandHandlerTest.class,
            GetGameStateHandlerTest.class
    })
public class CommandQueryTestSuite {
}
