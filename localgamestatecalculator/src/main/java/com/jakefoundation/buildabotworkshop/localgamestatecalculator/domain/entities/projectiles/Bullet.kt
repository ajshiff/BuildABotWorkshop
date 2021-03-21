package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.projectiles

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Collidable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Damaging
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Destroyable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Movable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.*

class Bullet (override val location: Location, override val direction: Direction)
        : Movable, Collidable, Destroyable, Damaging {
    override val speed: Speed = Speed(5.0)
    override val size: Size = Size(1.0)
    override val damage: Health = Health(4)

    private var hasCollided : Boolean = false

    override fun isDestroyed () : Boolean {
        return hasCollided;
    }


}