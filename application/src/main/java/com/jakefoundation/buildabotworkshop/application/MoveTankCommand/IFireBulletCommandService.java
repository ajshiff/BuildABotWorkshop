package main.java.com.jakefoundation.buildabotworkshop.application.MoveTankCommand;

/* Create a IFireBulletCommandService interface in the MoveTankCommand folder.
 *Give it one method called sendFireBulletRequest that takes a FireBulletRequest
 *(the same type as the DTO you just made) and returns an ResultStatus
 *(which is an enum that should be defined by now)
 */

public interface IFireBulletCommandService {
    void sendFireBulletRequest();


}
