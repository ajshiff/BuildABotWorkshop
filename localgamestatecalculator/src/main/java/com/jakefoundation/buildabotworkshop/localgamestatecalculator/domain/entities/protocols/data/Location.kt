package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data

data class Location(val x: Double, val y: Double) {
    operator fun plus (other: Location) : Location {
        return Location(x + other.x, y + other.y)
    }
}
