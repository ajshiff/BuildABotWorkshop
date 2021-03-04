package com.jakefoundation.buildabotworkshop.domain;

import com.jakefoundation.buildabotworkshop.domain.collectable.Collectable;
import com.jakefoundation.buildabotworkshop.domain.obstacle.Obstacle;
import com.jakefoundation.buildabotworkshop.domain.projectile.Projectile;
import com.jakefoundation.buildabotworkshop.domain.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private Unit yourUnit;

    private final List<Unit> units = new ArrayList<>();
    private final List<Projectile> projectiles = new ArrayList<>();
    private final List<Obstacle> obstacles = new ArrayList<>();
    private final List<Collectable> collectables = new ArrayList<>();
    private final GameBoard gameBoard = new GameBoard(0, 0);

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