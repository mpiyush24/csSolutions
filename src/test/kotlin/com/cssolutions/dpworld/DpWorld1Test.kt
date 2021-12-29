package com.cssolutions.dpworld

import org.junit.jupiter.api.Test

internal class MaximizeStolenAmountTest {

    @Test
    fun maximumValueStolen() {
        val result = MaximizeStolenAmount().maximumValueStolen(intArrayOf(5, 3, 4, 11, 2))
        println(result)
    }

    @Test
    fun maximumValueStolenDP(){
        val result = MaximizeStolenAmount().maximumValueStolenDP(intArrayOf(5, 3, 4, 11, 2))
        println(result)
    }
}