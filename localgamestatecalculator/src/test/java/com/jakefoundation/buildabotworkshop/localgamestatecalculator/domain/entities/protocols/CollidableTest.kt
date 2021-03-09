package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Location
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Size
import org.junit.Assert
import org.junit.Test

class CollidableTest {

    @Test
    fun isTouching_IS_whenObjectEdgesAreTouching () {
        val collidableA = CollidableThin(Size(1.0), Location(0.0, 0.0))
        val collidableB = CollidableThin(Size(1.0), Location(2.0, 0.0))
        val result = collidableA.isTouching(collidableB)
        Assert.assertTrue(result)
    }

    @Test
    fun isTouching_WhenEdgesTouch_IsTheSameFromBothObjects () {
        val collidableA = CollidableThin(Size(1.0), Location(0.0, 0.0))
        val collidableB = CollidableThin(Size(1.0), Location(2.0, 0.0))
        val resultFromA = collidableA.isTouching(collidableB)
        val resultFromB = collidableB.isTouching(collidableA)
        Assert.assertEquals(resultFromA, resultFromB)
    }

    @Test
    fun isTouching_IS_whenObjectsOfDifferentRadiusAreOnTheSameSpot () {
        val collidableA = CollidableThin(Size(1.0), Location(0.0, 0.0))
        val collidableB = CollidableThin(Size(2.0), Location(0.0, 0.0))
        val result = collidableA.isTouching(collidableB)
        Assert.assertTrue(result)
    }

    @Test
    fun isTouching_IS_NOT_whenObjectsAreTooFar () {
        val collidableA = CollidableThin(Size(1.0), Location(0.0, 0.0))
        val collidableB = CollidableThin(Size(1.0), Location(2.1, 0.0))
        val result = collidableA.isTouching(collidableB)
        Assert.assertFalse(result)
    }

    private class CollidableThin(override val size: Size,
                                 override val location: Location) : Collidable {}
}