package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Location
import kotlin.math.pow
import kotlin.math.sqrt

interface Locatable {
    val location : Location
    fun distanceBetween (otherLocation: Location) : Double {
        val aSquare: Double = (this.location.x - otherLocation.x).pow(2)
        val bSquare: Double = (this.location.y - otherLocation.y).pow(2)
        val cSquare = aSquare + bSquare
        return sqrt(cSquare)
    }

    fun distanceBetween (other: Locatable) : Double {
        return this.distanceBetween(other.location)
    }
}
