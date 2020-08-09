package com.cssolutions.algorithm.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SumArrayKtTest {

    @Test
    fun sumArrayTest() {
        val result = sumArray(intArrayOf(1, 2, 3))

        assertEquals(result[0], 1)
        assertEquals(result[1], 3)
        assertEquals(result[2], 6)
    }
}