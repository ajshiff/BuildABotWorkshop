package com.jakefoundation.buildabotworkshop;

import androidx.lifecycle.ViewModel;

import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.MoveTankCommandHandler;
import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.application.fireBulletCommand.FireBulletCommandHandler;
import com.jakefoundation.buildabotworkshop.application.getgamestate.GetGameStateQueryHandler;
import com.jakefoundation.buildabotworkshop.bots.AaronBot;
import com.jakefoundation.buildabotworkshop.bots.DanielBot;
import com.jakefoundation.buildabotworkshop.bots.MikeBot;
import com.jakefoundation.buildabotworkshop.bots.PamBot;
import com.jakefoundation.buildabotworkshop.domain.Bot;
import com.jakefoundation.buildabotworkshop.domain.GameState;
import com.jakefoundation.buildabotworkshop.domain.projectile.Projectile;
import com.jakefoundation.buildabotworkshop.domain.unit.Unit;
import com.jakefoundation.buildabotworkshop.infrastructure.GameStateService;
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation.LocalGameStateRequestHandler;
import com.jakefoundation.buildabotworkshop.models.Player;
import com.jakefoundation.buildabotworkshop.models.TankColors;

import java.util.ArrayList;
import java.util.List;

public class GamePlayerViewModel extends ViewModel {
    private final GameStateService gss = new GameStateService(new LocalGameStateRequestHandler());
    private final GetGameStateQueryHandler getGameState = new GetGameStateQueryHandler(gss);
    private final FireBulletCommandHandler fireBulletCommand = new FireBulletCommandHandler(gss);
    private final MoveTankCommandHandler moveTankCommand = new MoveTankCommandHandler(gss);
    private final List<Player> players = registerPlayers();
    // List of Tanks
    public List<Unit> units;
    // List of Bullets
    public List<Projectile> projectiles;
    // Other Game-State info


    // hard coded list of 4 players for now
    public List<Player> registerPlayers () {
        Bot aaronBot = new AaronBot();
        Bot pamBot = new PamBot();
        Bot mikeBot = new MikeBot();
        Bot danBot = new DanielBot();
        Authorization aaronAuth = new Authorization("Aaron", "11111");
        Authorization pamAuth = new Authorization("Pam", "22222");
        Authorization mikeAuth = new Authorization("Mike", "33333");
        Authorization danAuth = new Authorization("Daniel", "44444");
        List<Player> players = new ArrayList<>();
        players.add(new Player(aaronAuth, aaronBot, TankColors.blue));
        players.add(new Player(pamAuth, pamBot, TankColors.pink));
        players.add(new Player(mikeAuth, mikeBot, TankColors.green));
        players.add(new Player(danAuth, danBot, TankColors.orange));
        return players;
    }

    public void getGameUpdates () {
        GameState gs = getGameState(players.get(0));
        units = gs.getUnits();
        projectiles = gs.getProjectiles();
    }

    private GameState getGameState(Player player) {
        return getGameState.getGameState(player.getAuth());
    }

    public void sendFireRequest (Player player) {
        fireBulletCommand.handleFireBulletCommand(player.getAuth(), player.getBot().fireCommand(getGameState(player)));
    }

    public void sendMoveRequest (Player player) {
        moveTankCommand.handleMoveTankCommand(player.getAuth(), player.getBot().moveCommand(getGameState(player)));
    }

}