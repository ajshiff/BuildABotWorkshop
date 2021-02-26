package com.jakefoundation.buildabotworkshop.domain;

import org.junit.Assert;
import org.junit.Test;

public class AngleTest {
    @Test
    public void negativeAngle_givesPositiveAngle () {
        double degrees = -90;
        Angle angle = new Angle(degrees);
        Assert.assertEquals(270, angle.getAngleValue(), 0.1);
    }

    @Test
    public void negativeTooLargeAngle_givesPositiveAngle () {
        double degrees = -450;
        Angle angle = new Angle(degrees);
        Assert.assertEquals(270, angle.getAngleValue(), 0.1);
    }

    @Test
    public void positiveTooLargeAngle_givesPositiveAngle () {
        double degrees = 450;
        Angle angle = new Angle(degrees);
        Assert.assertEquals(90, angle.getAngleValue(), 0.1);
    }

    @Test
    public void positiveAngle_givesPositiveAngle () {
        double degrees = 90;
        Angle angle = new Angle(degrees);
        Assert.assertEquals(90, angle.getAngleValue(), 0.1);
    }

    @Test
    public void positive360Angle_givesZeroAngle () {
        double degrees = 360;
        Angle angle = new Angle(degrees);
        Assert.assertEquals(0, angle.getAngleValue(), 0.1);
    }

    @Test
    public void negative360Angle_givesZeroAngle () {
        double degrees = -360;
        Angle angle = new Angle(degrees);
        Assert.assertEquals(0, angle.getAngleValue(), 0.1);
    }
}