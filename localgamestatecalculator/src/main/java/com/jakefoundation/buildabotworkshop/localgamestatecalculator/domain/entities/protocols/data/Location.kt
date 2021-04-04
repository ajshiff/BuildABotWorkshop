package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data

data class Location(val x: Double, val y: Double) {
    operator fun plus (other: Location) : Location {
        return Location(x + other.x, y + other.y)
    }

    fun loopLocation (maxX: Int, maxY: Int) : Location {
        val newX = this.x % maxX
        val newY = this.y % maxY
        return Location((if (newX < 0) newX + maxX else newX), (if (newY < 0) newY + maxY else newY))
    }
}
