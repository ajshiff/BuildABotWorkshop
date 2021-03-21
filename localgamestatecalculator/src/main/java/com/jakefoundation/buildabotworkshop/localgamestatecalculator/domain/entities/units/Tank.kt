package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.units

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Collidable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Damageable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Destroyable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Directable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.*

data class Tank(override val location: Location)
        : Directable, Collidable, Damageable, Destroyable {
    override val maxSpeed: Speed = Speed(3.0)
    override val size: Size = Size(3.0)
    override val health: Health = Health(9)

    var direction: Direction = Direction(0.0)
    var currentSpeed : Speed = Speed (0.0)

    override fun isDestroyed(): Boolean {
        return health.health <= 0
    }

    override fun move(direction: Direction, speed: Speed): Location {
        this.direction = direction
        this.currentSpeed = speed
        return super.move(direction, speed)
    }
}