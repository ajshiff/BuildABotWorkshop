package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.projectiles

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.*
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.*
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.units.Tank
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

data class Bullet (override val location: Location, override val direction: Direction)
        : Movable, Collidable, Destroyable, Damaging {
    override val speed: Speed = Speed(40.0)
    override val size: Size = Size(75.0)
    override val damage: Health = Health(4)

    private var hasCollided : Boolean = false

    override fun isDestroyed () : Boolean {
        return hasCollided
    }

    override fun isTouching(otherCollidable: Collidable): Boolean {
        val touches = super.isTouching(otherCollidable)
        if (touches && otherCollidable is Damageable) {
            otherCollidable.takeDamage(damage)
            hasCollided = true
        }
        return touches
    }


}