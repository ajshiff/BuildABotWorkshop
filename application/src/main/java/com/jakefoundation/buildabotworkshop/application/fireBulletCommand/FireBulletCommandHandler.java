package com.jakefoundation.buildabotworkshop.application.fireBulletCommand;
/**The handleFireBulletCommand method takes two parameters.
*A FireBulletCommand and an Authorization objects.
**If the FireBulletCommand.getDoFire() == ShouldDo.dont, then return ResultStatus.success else,

  1 - Create a new FireBulletRequest object using these provided pieces of data.
  2 - Pass this MoveTankRequest that you just made, to the method on the IMoveTankCommandService.
  3 - Return the value given by the IMoveTankCommandService.
*/
import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;
import com.jakefoundation.buildabotworkshop.domain.FireBulletCommand;
import com.jakefoundation.buildabotworkshop.domain.ShouldDo;

public class FireBulletCommandHandler {

    private final IFireBulletCommandService fireBulletService;


    /**
     * Another constructor for class FireBulletCommandHandler
     * @param fireBulletService   <the handler for the firing command>
     */
    public FireBulletCommandHandler(IFireBulletCommandService fireBulletService) {
        this.fireBulletService = fireBulletService;
    }

    /**
     * method handler to firebulletcommand that states the actions of the bullet once is fired
     * @return ResultStatus if success
     * @param auth  <the id authorization passcode>
     * @param fireBulletCommand  <the handler for the firing command>
     * @return fireBulletService if new FireBulletRequest
     */
    public ResultStatus handleFireBulletCommand(Authorization auth, FireBulletCommand fireBulletCommand){
        if (fireBulletCommand.getDoFire() == ShouldDo.dont) {
            return ResultStatus.success;
        }
        FireBulletRequest request = new FireBulletRequest(auth, fireBulletCommand);
        return fireBulletService.sendFireBulletRequest(request);
    }
}



