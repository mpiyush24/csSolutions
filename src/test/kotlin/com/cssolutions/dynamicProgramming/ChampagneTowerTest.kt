package com.cssolutions.dynamicProgramming

import com.cssolutions.dsalgo.dynamicProgramming.ChampagneTower
import org.junit.jupiter.api.Test

internal class ChampagneTowerTest {

    @Test
    fun champagneTower() {
        val champagneTower = ChampagneTower().champagneTowerDP(10000,2,1)
        println(champagneTower)
    }
}