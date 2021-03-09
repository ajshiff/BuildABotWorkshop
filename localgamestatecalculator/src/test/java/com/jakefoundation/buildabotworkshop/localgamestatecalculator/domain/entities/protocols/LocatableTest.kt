package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Location
import org.junit.Assert
import org.junit.Test

class LocatableTest() {
    private val precisionDelta = 0.01

    @Test
    fun distanceBetween_isCorrect () {
        val locatableA = LocatableThin(Location(0.0, 0.0))
        val locatableB = LocatableThin(Location(3.0, 4.0))
        val result = locatableA.distanceBetween(locatableB)
        val expected = 5.0
        Assert.assertEquals(expected, result, precisionDelta)
    }

    @Test
    fun distanceBetween_callerDoesntMatter () {
        val locatableA = LocatableThin(Location(0.0, 0.0))
        val locatableB = LocatableThin(Location(3.0, 4.0))
        val aTakesB = locatableA.distanceBetween(locatableB)
        val bTakesA = locatableB.distanceBetween(locatableA)
        Assert.assertEquals(aTakesB, bTakesA, precisionDelta)
    }

    private class LocatableThin(override val location: Location) : Locatable {
    }
}