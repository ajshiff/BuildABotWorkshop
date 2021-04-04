package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Direction
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Location
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Speed
import kotlin.math.cos
import kotlin.math.sin

interface Movable : Locatable {
    val direction : Direction
    val speed: Speed

    fun move () : Location {
        val deltaX = cos(((direction.direction % 360) * (Math.PI / 180))) * speed.speed
        val deltaY = sin(((direction.direction % 360) * (Math.PI / 180))) * speed.speed
        val deltaLocation = Location(deltaX, deltaY)
        return location + deltaLocation;
    }
}