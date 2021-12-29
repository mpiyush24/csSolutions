package com.cssolutions.dsalgo.easy

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HeightCheckerKtTest {

    @Test
    fun heightCheckerTest() {
        val totalMoves = heightChecker(intArrayOf(5,1,2,3,4))
        assertEquals(5, totalMoves)
    }
}