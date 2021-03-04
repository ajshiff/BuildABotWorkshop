package com.jakefoundation.buildabotworkshop.domain.obstacle;

import com.jakefoundation.buildabotworkshop.domain.Position;

public class Obstacle {
    private Position position;
    private ObstacleType type;

    public Obstacle(Position position, ObstacleType type) {
        this.position = position;
        this.type = type;
    }

    public Position getPosition() {
        return position;
    }
    public ObstacleType getType() {
        return type;
    }
}