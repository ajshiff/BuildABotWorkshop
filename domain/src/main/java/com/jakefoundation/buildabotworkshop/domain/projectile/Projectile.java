package com.jakefoundation.buildabotworkshop.domain.projectile;

import com.jakefoundation.buildabotworkshop.domain.Angle;
import com.jakefoundation.buildabotworkshop.domain.Position;
import com.jakefoundation.buildabotworkshop.domain.Speed;

public class Projectile {
    private final ProjectileType projectileType;
    private final Position pos;
    private final Angle angle;
    private final Speed speed;

    public Projectile (ProjectileType projectileType, Position pos, Angle angle, Speed speed) {

        this.projectileType = projectileType;
        this.pos = pos;
        this.angle = angle;
        this.speed = speed;
    }

    public ProjectileType getProjectileType() {
        return projectileType;
    }

    public Position getPos() {
        return pos;
    }

    public Angle getAngle() {
        return angle;
    }

    public Speed getSpeed() {
        return speed;
    }
}
