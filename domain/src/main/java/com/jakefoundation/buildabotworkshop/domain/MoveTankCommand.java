package com.jakefoundation.buildabotworkshop.domain;

//class
public class MoveTankCommand {

    //finals
    private final ShouldDo shouldDo;
    private final Angle angle;
    private final Speed speed;

    //constructor
    public MoveTankCommand(ShouldDo shouldDo, Angle angle, Speed speed) {
        this.shouldDo = shouldDo;
        this.angle = angle;
        this.speed = speed;
    }

    //getters
    public ShouldDo getShouldMove() {
        return shouldDo;
    }
    public Angle getDirection() {
        return angle;
    }
    public Speed getSpeed() {
        return speed;
    }
}
