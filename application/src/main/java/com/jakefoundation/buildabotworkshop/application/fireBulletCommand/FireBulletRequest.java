package main.java.com.jakefoundation.buildabotworkshop.application.fireBulletCommand;

/*Create a FireBulletRequest class in the FireBulletCommand folder, according to this UML.
 Let Private Fields be final.
 */

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import main.java.com.jakefoundation.buildabotworkshop.domain.FireBulletCommand;

public class FireBulletRequest
//creates a class
{
    private final String username;
    private final String password;
    private final double angle;


    public FireBulletRequest(Authorization,
                             Authorization,
                             FireBulletCommand FireBulletCommand fireBulletCommand)
    {
        this.username = Authorization.getUsername();
        this.password= Authorization.getPassword();
        this.angle = FireBulletCommand.getAngle().getAngleValue();

    }


    public double getAngle() {
        return angle;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}