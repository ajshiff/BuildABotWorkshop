package com.jakefoundation.buildabotworkshop.application.fireBulletCommand;

/**Create a FireBulletRequest class in the FireBulletCommand folder, according to this UML.
 Let Private Fields be final.
 */

import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.domain.FireBulletCommand;

public class FireBulletRequest
//creates a class
{
    private final String username;
    private final String password;
    private final double angle;

    /**
     * Another constructor for class FireBulletRequest
     * @param authorization  <the id authorization>
     * @param fireBulletCommand   <the handler for the firing command>
     */
    public FireBulletRequest(Authorization authorization,
                             FireBulletCommand fireBulletCommand)
    {
        this.username = authorization.getUsername();
        this.password= authorization.getPassword();
        this.angle = fireBulletCommand.getAngle().getAngleValue();

    }

    /**
     * @return the angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }


}