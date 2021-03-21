package com.jakefoundation.buildabotworkshop.infrastructure;

import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.IMoveTankCommandService;
import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.MoveTankRequest;
import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;
import com.jakefoundation.buildabotworkshop.application.fireBulletCommand.FireBulletRequest;
import com.jakefoundation.buildabotworkshop.application.fireBulletCommand.IFireBulletCommandService;
import com.jakefoundation.buildabotworkshop.application.getgamestate.GetGameStateRequest;
import com.jakefoundation.buildabotworkshop.application.getgamestate.IGetGameStateService;
import com.jakefoundation.buildabotworkshop.application.spawntankrequest.ISpawnTankService;
import com.jakefoundation.buildabotworkshop.application.spawntankrequest.SpawnTankRequest;
import com.jakefoundation.buildabotworkshop.domain.Angle;
import com.jakefoundation.buildabotworkshop.domain.GameBoard;
import com.jakefoundation.buildabotworkshop.domain.GameState;
import com.jakefoundation.buildabotworkshop.domain.HitPoints;
import com.jakefoundation.buildabotworkshop.domain.Owner;
import com.jakefoundation.buildabotworkshop.domain.Position;
import com.jakefoundation.buildabotworkshop.domain.Speed;
import com.jakefoundation.buildabotworkshop.domain.collectable.Collectable;
import com.jakefoundation.buildabotworkshop.domain.obstacle.Obstacle;
import com.jakefoundation.buildabotworkshop.domain.projectile.Projectile;
import com.jakefoundation.buildabotworkshop.domain.projectile.ProjectileType;
import com.jakefoundation.buildabotworkshop.domain.unit.Unit;
import com.jakefoundation.buildabotworkshop.domain.unit.UnitType;
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.obstacles.Wall;
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.projectiles.Bullet;
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.units.Tank;
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation.GameStateTracker;
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation.LocalGameStateRequestHandler;
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation.OwnedBullet;
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation.OwnedTank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GameStateService implements IFireBulletCommandService, IGetGameStateService, IMoveTankCommandService, ISpawnTankService {

    private final LocalGameStateRequestHandler gameCalc;

    public GameStateService (LocalGameStateRequestHandler gameCalc) {
        this.gameCalc = gameCalc;
    }

    @Override
    public ResultStatus sendSpawnTankRequest(SpawnTankRequest spawnTankRequest) {
        gameCalc.receiveSpawnTankRequest(spawnTankRequest);
        return ResultStatus.failure;
    }

    @Override
    public ResultStatus sendMoveTankRequest(MoveTankRequest moveTankRequest) {
        gameCalc.receiveMoveCommand(moveTankRequest);
        return ResultStatus.failure;
    }

    @Override
    public ResultStatus sendFireBulletRequest(FireBulletRequest fireBulletRequest) {
        gameCalc.receiveFireCommand(fireBulletRequest);
        return ResultStatus.failure;
    }

    @Override
    public GameState sendGetGameStateRequest(final GetGameStateRequest getGameStateRequest) {
        GameStateTracker gs = gameCalc.receiveGetGameStateRequest(getGameStateRequest);

        List<Unit> domainTanks = gs.getTanks().stream().map(
            new Function<OwnedTank, Unit>() {
                @Override
                public Unit apply(OwnedTank tank) {
                    Tank ownedTank = tank.getTank();
                    return new Unit(
                        UnitType.tank,
                        new Position(ownedTank.getLocation().getX(), ownedTank.getLocation().getY()),
                        new Angle(ownedTank.getDirection().getDirection()),
                        new Speed(ownedTank.getCurrentSpeed().getSpeed()),
                        new HitPoints(ownedTank.getHealth().getHealth()),
                        new Owner(tank.getOwner())
                    );
                }
            }).collect(Collectors.<Unit>toList());
        List<Projectile> domainProjectiles = gs.getBullets().stream().map(new Function<OwnedBullet, Projectile>() {
            @Override
            public Projectile apply(OwnedBullet bullet) {
                Bullet b = bullet.getBullet();
                return new Projectile(
                        ProjectileType.bullet,
                        new Position(b.getLocation().getX(), b.getLocation().getY()),
                        new Angle(b.getDirection().getDirection()),
                        new Speed(b.getSpeed().getSpeed())
                );
            }
        }).collect(Collectors.<Projectile>toList());

        List<Unit> yourUnitList = domainTanks.stream().filter(new Predicate<Unit>() {
            @Override
            public boolean test(Unit unit) {
                return unit.getOwner().getOwnerName().equals(getGameStateRequest.getUsername());
            }
        }).collect(Collectors.<Unit>toList());
        Unit yourUnit = null;
        if (yourUnitList.size() > 0)
        {
            yourUnit = yourUnitList.get(0);
        }

        GameBoard domainGameBoard = new GameBoard(gs.getGameBoard().getX(), gs.getGameBoard().getY());

        List<Obstacle> domainObstacles = new ArrayList<>();
        List<Collectable> domainCollectables = new ArrayList<>();

        return new GameState (
                yourUnit,
                domainTanks,
                domainProjectiles,
                domainObstacles,
                domainCollectables,
                domainGameBoard
        );
    }
}