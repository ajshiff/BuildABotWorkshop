package com.jakefoundation.buildabotworkshop;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.MoveTankCommandHandler;
import com.jakefoundation.buildabotworkshop.application.common.Authorization;
import com.jakefoundation.buildabotworkshop.application.fireBulletCommand.FireBulletCommandHandler;
import com.jakefoundation.buildabotworkshop.application.getgamestate.GetGameStateQueryHandler;
import com.jakefoundation.buildabotworkshop.application.spawntankrequest.SpawnTankRequestHandler;
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
    private final SpawnTankRequestHandler spawnTankCommand = new SpawnTankRequestHandler(gss);
    public final List<Player> players = registerPlayers();
    // List of Tanks
//    public List<Unit> units;
    // List of Bullets
    public GameState gameState;
    // Other Game-State info


    // hard coded list of 4 players for now
    private List<Player> registerPlayers () {
        Bot aaronBot = new AaronBot();
        Bot pamBot = new PamBot();
        Bot mikeBot = new MikeBot();
        Bot danBot = new DanielBot();
        Authorization aaronAuth = new Authorization("Aaron", "11111");
        Authorization pamAuth = new Authorization("Pam", "22222");
        Authorization mikeAuth = new Authorization("Mike", "33333");
        Authorization danAuth = new Authorization("Daniel", "44444");
        List<Player> players = new ArrayList<>();
        players.add(new Player(aaronAuth, aaronBot, TankColors.cyan));
        players.add(new Player(pamAuth, aaronBot, TankColors.pink));
//        players.add(new Player(pamAuth, pamBot, TankColors.pink));
//        players.add(new Player(mikeAuth, mikeBot, TankColors.green));
//        players.add(new Player(danAuth, danBot, TankColors.orange));
        return players;
    }

    private void getGameUpdates () {
        gameState = getGameState(players.get(0));
    }

    private GameState getGameState(Player player) {
        return getGameState.getGameState(player.getAuth());
    }

    private void sendFireRequest (Player player, GameState gs) {
        fireBulletCommand.handleFireBulletCommand(player.getAuth(), player.getBot().fireCommand(gs));
    }

    private void sendMoveRequest (Player player, GameState gs) {
        moveTankCommand.handleMoveTankCommand(player.getAuth(), player.getBot().moveCommand(gs));
    }

    // run once
    public void init() {
        for (Player player : players) {
            spawnTankCommand.handleSpawnTankCommand(player.getAuth());
        }
    }

    // put in a game loop
    public void playLoop () {
//        Log.i("YAY","BOOP BOOP SCOOP");
        // get updated info for displaying
        getGameUpdates();
        // run each player's action
        for (Player player : players) {
            GameState gs = getGameState(player);
            player.setSelfDetails(gs.getYourUnit());
            sendFireRequest(player, gs);
            sendMoveRequest(player, gs);
        }
    }

}