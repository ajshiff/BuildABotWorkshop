package main.java.com.jakefoundation.buildabotworkshop.domain;
/*
Create a FireBulletCommand class according to this UML.
Private fields should be final.
*/

import com.jakefoundation.buildabotworkshop.domain.ShouldDo;
import com.jakefoundation.buildabotworkshop.domain.Angle;

public class FireBulletCommand {
    //creates a class with finals

    private final ShouldDo doFire;
    private final Angle angle;

    public FireBulletCommand(ShouldDo doFire, Angle angle) {
        //constructor
        this.doFire = doFire;
        this.angle = angle;


    }

    //getters
    public ShouldDo getDoFire() {
        return doFire;
    }

    public static Angle getAngle() {
        return angle;
    }
}
