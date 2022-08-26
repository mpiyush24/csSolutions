package com.cssolutions.dsalgo.graph

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MaximumGoldTest {

    @Test
    fun getMaximumGold() {
        print(
            MaximumGold().getMaximumGold(
                arrayOf(
                    intArrayOf(1, 0, 7, 0, 0, 0),
                    intArrayOf(2, 0, 6, 0, 1, 0),
                    intArrayOf(3, 5, 6, 7, 4, 2),
                    intArrayOf(4, 3, 1, 0, 2, 0),
                    intArrayOf(3, 0, 5, 0, 20, 0)
                )
            )
        )
    }
}