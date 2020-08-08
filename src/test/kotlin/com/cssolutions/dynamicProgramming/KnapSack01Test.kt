package com.cssolutions.dynamicProgramming

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class KnapSack01Test {

    @Test
    fun knapsack01Recursion() {
        val maxProfit = KnapSack01().knapsack01Recursion(intArrayOf(1, 3, 4, 5),intArrayOf(1, 3, 4, 5),9, 0, 0 )
        assertEquals(9, maxProfit)
    }

    @Test
    fun knapsack01DP() {
        val maxProfit = KnapSack01().knapsack01DP(intArrayOf(1, 3, 4, 5),intArrayOf(1, 3, 4, 5),9 )
        assertEquals(9, maxProfit)
    }
}