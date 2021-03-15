package com.jakefoundation.buildabotworkshop.domain;

import com.jakefoundation.buildabotworkshop.domain.collectable.Collectable;
import com.jakefoundation.buildabotworkshop.domain.obstacle.Obstacle;
import com.jakefoundation.buildabotworkshop.domain.projectile.Projectile;
import com.jakefoundation.buildabotworkshop.domain.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private final Unit yourUnit;
    private final List<Unit> units;
    private final List<Projectile> projectiles;
    private final List<Obstacle> obstacles;
    private final List<Collectable> collectables;
    private final GameBoard gameBoard;

    public GameState (
            Unit yourUnit,
            List<Unit> units,
            List<Projectile> projectiles,
            List<Obstacle> obstacles,
            List<Collectable> collectables,
            GameBoard gameBoard) {
        this.yourUnit = yourUnit;
        this.units = units;
        this.projectiles = projectiles;
        this.obstacles = obstacles;
        this.collectables = collectables;
        this.gameBoard = gameBoard;
    }

    public Unit getYourUnit() {
        return yourUnit;
    }
    public GameBoard getGameBoard() {
        return gameBoard;
    }
    public List<Unit> getUnits() {
        return units;
    }
    public List<Projectile> getProjectiles() {
        return projectiles;
    }
    public List<Obstacle> getObstacles() {
        return obstacles;
    }
    public List<Collectable> getCollectables() {
        return collectables;
    }
}