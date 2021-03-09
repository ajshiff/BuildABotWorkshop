package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Size

interface Collidable : Locatable {
    val size: Size
    fun isTouching (otherCollidable: Collidable) : Boolean {
        val touchDistance = this.size.radius + otherCollidable.size.radius
        return this.distanceBetween(otherCollidable) <= touchDistance
    }
}