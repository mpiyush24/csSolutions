package com.cssolutions.dynamicProgramming

import org.junit.jupiter.api.Test

internal class ChampagneTowerTest {

    @Test
    fun champagneTower() {
        val champagneTower = ChampagneTower().champagneTowerDP(10000,2,1)
        println(champagneTower)
    }
}