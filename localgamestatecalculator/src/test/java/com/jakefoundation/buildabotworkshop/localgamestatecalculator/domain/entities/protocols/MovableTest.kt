package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Direction
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Location
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Speed
import org.junit.Assert
import org.junit.Test

class MovableTest() {
    private val precisionDelta = 0.01

    @Test
    fun moveRight_isCorrect () {
        val movableA = MovableThin( Direction(0.0),
                Speed(10.0),
                Location(0.0, 0.0)
        )
        val result = movableA.move()
        val expected = Location(10.0, 0.0);
        Assert.assertEquals(expected.x, result.x, precisionDelta)
        Assert.assertEquals(expected.y, result.y, precisionDelta)
    }
    @Test
    fun moveLeft_isCorrect () {
        val movableA = MovableThin( Direction(180.0),
                Speed(10.0),
                Location(0.0, 0.0)
        )
        val result = movableA.move()
        val expected = Location(-10.0, 0.0);
        Assert.assertEquals(expected.x, result.x, precisionDelta)
        Assert.assertEquals(expected.y, result.y, precisionDelta)
    }

    @Test
    fun moveUp_isCorrect () {
        val movableA = MovableThin( Direction(90.0),
                Speed(10.0),
                Location(0.0, 0.0)
        )
        val result = movableA.move()
        val expected = Location(0.0, 10.0);
        Assert.assertEquals(expected.x, result.x, precisionDelta)
        Assert.assertEquals(expected.y, result.y, precisionDelta)
    }

    @Test
    fun moveDown_isCorrect () {
        val movableA = MovableThin( Direction(270.0),
                Speed(10.0),
                Location(0.0, 0.0)
        )
        val result = movableA.move()
        val expected = Location(0.0, -10.0);
        Assert.assertEquals(expected.x, result.x, precisionDelta)
        Assert.assertEquals(expected.y, result.y, precisionDelta)
    }

    @Test
    fun moveDiagonal_isCorrect () {
        val movableA = MovableThin( Direction(45.0),
                Speed(10.0),
                Location(0.0, 0.0)
        )
        val result = movableA.move()
        val expected = Location(7.07, 7.07);
        Assert.assertEquals(expected.x, result.x, precisionDelta)
        Assert.assertEquals(expected.y, result.y, precisionDelta)
    }

    private class MovableThin(override val direction: Direction,
                                override val speed: Speed,
                                override val location: Location): Movable {
    }
}