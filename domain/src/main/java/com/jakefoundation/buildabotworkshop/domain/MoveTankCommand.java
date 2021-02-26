package com.jakefoundation.buildabotworkshop.domain;

/* Create a MoveTankCommand class according to this UML.
 * The private fields should be final.
 */

public class MoveTankCommand {
    //class

    //finals
    private final double doMove;
    private final double angle;
    private final double speed;

    public MoveTankCommand(double ShouldDo , double Angle, double Speed) {
        //constructor
        this.doMove = ShouldDo;
        this.angle = Angle;
        this.speed = Speed;
    }

    //getters
    public double getDoMove() {
        return doMove;
    }

    public double getDirection() {
        return angle;
    }
    public double getSpeed() {
        return speed;
    }
}
