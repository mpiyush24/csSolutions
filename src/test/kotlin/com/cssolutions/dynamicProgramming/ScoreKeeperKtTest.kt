package com.cssolutions.dynamicProgramming

import com.cssolutions.dsalgo.dynamicProgramming.scoreKeeper
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ScoreKeeperKtTest {

    @Test
    fun scoreKeeperTest() {
        val result = scoreKeeper(8, listOf("5", "-2" , "4", "Z", "X", "9", "+" , "+" ))

        assertEquals(27, result)
    }
}