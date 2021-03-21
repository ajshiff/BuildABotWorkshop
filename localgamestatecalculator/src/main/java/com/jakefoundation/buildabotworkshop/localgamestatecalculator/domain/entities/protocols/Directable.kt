package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Direction
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Location
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Speed
import kotlin.math.cos
import kotlin.math.sin

interface Directable : Locatable {
    val maxSpeed : Speed
    fun move (direction: Direction, speed: Speed) : Location {
        val deltaX = cos(direction.direction) * speed.speed
        val deltaY = sin(direction.direction) * speed.speed
        val deltaLocation = Location(deltaX, deltaY)
        return location + deltaLocation;
    }
}