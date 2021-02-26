package com.jakefoundation.buildabotworkshop.domain;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {
    @Test
    public void firstConstructorArg_isX () {
        double firstArg = 1;
        double secondArg = -12;
        Position pos = new Position(firstArg, secondArg);
        Assert.assertEquals(firstArg, pos.getX(), 0.1);
    }

    @Test
    public void secondConstructorArg_isY () {
        double firstArg = 1;
        double secondArg = -12;
        Position pos = new Position(firstArg, secondArg);
        Assert.assertEquals(secondArg, pos.getY(), 0.1);
    }

    @Test
    public void distanceBetween_isCorrect () {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position (3, 4);
        double distanceBetween = pos1.distanceBetween(pos2);
        Assert.assertEquals(5, distanceBetween, 0.1);
    }
}
