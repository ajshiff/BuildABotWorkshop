package main.java.com.jakefoundation.buildabotworkshop.application.fireBulletCommand;

/*Create a FireBulletRequest class in the FireBulletCommand folder, according to this UML.
 Let Private Fields be final.
 */
import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;
import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import main.java.com.jakefoundation.buildabotworkshop.domain.FireBulletCommand;

public class FireBulletRequest
//creates a class
{
    private final Authorization username;
    private final Authorization password;
    private final FireBulletCommand angle;


    public FireBulletRequest(Authorization username,
                             Authorization password,
                             FireBulletCommand angle)
    {
        this.username = username;
        this.password = password;
        this.angle = angle;

    }

    public FireBulletCommand getAngle() {
        return angle;
    }

    public Authorization getUsername() {
        return username;
    }

    public Authorization getPassword() {
        return password;
    }


}