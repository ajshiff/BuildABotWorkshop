package com.jakefoundation.buildabotworkshop.domain.unit;

import com.jakefoundation.buildabotworkshop.domain.Angle;
import com.jakefoundation.buildabotworkshop.domain.HitPoints;
import com.jakefoundation.buildabotworkshop.domain.Owner;
import com.jakefoundation.buildabotworkshop.domain.Position;
import com.jakefoundation.buildabotworkshop.domain.Speed;

public class Unit {

  private final UnitType unitType;
  private final Position position;
  private final Angle angle;
  private final Speed speed;
  private final HitPoints remainHitPoints;
  private final Owner owner;

  public Unit (UnitType unitType,
      Position pos,
      Angle angle,
      Speed speed,
      HitPoints hp,
      Owner owner) {

    this.unitType = unitType;
    this.position = pos;
    this.angle = angle;
    this.speed = speed;
    this.remainHitPoints = hp;
    this.owner = owner;
  }

  public UnitType getUnitType() {
    return unitType;
  }

  public Position getPosition() {
    return position;
  }

  public Angle getAngle() {
    return angle;
  }

  public Speed getSpeed() {
    return speed;
  }

  public HitPoints getRemainHitPoints() {
    return remainHitPoints;
  }

  public Owner getOwner() {
    return owner;
  }
}
