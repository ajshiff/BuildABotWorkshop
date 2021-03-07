package main.java.com.jakefoundation.buildabotworkshop.application.fireBulletCommand;
/*The handleFireBulletCommand method takes two parameters.
*A FireBulletCommand and an Authorization objects.
**If the FireBulletCommand.getDoFire() == ShouldDo.dont, then return ResultStatus.success else,

  1 - Create a new FireBulletRequest object using these provided pieces of data.
  2 - Pass this MoveTankRequest that you just made, to the method on the IMoveTankCommandService.
  3 - Return the value given by the IMoveTankCommandService.
*/
import main.java.com.jakefoundation.buildabotworkshop.application.MoveTankCommand.IFireBulletCommandService;
import main.java.com.jakefoundation.buildabotworkshop.domain.FireBulletCommand;
import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;

public class FireBulletCommandHandler {

    private final IFireBulletCommandService fireBulletService;




    public FireBulletCommandHandler(IFireBulletCommandService fireBulletService) {
        this.fireBulletService = fireBulletService;
    }

    public ResultStatus handleFireBulletCommand(FireBulletCommand fireBulletCommand){
        FireBulletRequest request = new FireBulletRequest(fireBulletCommand);
        ResultStatus result = fireBulletService.sendFireBulletRequest(request);
        return result;

        IFireBulletCommandService iFireBulletCommandService;
        iFireBulletCommandService = new ResultStatus();


    }
}



