package com.cssolutions.algorithm.easy

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ReshapeMatrixKtTest {

    @Test
    fun reShapeMatrixTest() {
        val result = reShapeMatrix(arrayOf(intArrayOf(1,2), intArrayOf(3,4)), 1, 4)
        assertEquals(result.size, 1)
        assertEquals(result[0].size, 4)
    }
}