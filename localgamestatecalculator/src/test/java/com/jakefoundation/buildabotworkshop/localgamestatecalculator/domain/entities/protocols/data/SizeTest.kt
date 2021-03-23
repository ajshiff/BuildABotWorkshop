package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data

import org.junit.Assert
import org.junit.Test

class SizeTest {
    @Test
    fun sizeThrows_whenRadius_isLessThanZero () {
        try {
            Size(-1.0)
        } catch (_ : Exception) {
            return
        }
        Assert.fail("size did not throw when radius is less than 0")
    }

    @Test
    fun sizeDoesNotThrow_whenRadius_isZero () {
        try {
            Size(0.0)
        } catch (_: Exception) {
            Assert.fail("size threw when radius is equal to 0")
        }
    }

    @Test
    fun sizeDoesNotThrow_whenRadius_isGreaterThanZero () {
        try {
            Size(1.0)
        } catch (_: Exception) {
            Assert.fail("size threw when radius is greater than 0")
        }
    }

}