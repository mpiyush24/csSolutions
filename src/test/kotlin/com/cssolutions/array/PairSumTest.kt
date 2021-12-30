package com.cssolutions.array

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PairSumTest {

    @Test
    fun numberOfWays() {
        val result = PairSum().numberOfWays(intArrayOf(1,5,3,3,3).toTypedArray(), 6)
        assertEquals(6, result)
    }
}