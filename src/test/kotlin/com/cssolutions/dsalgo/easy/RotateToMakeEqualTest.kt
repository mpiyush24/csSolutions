package com.cssolutions.dsalgo.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RotateToMakeEqualTest {
    @Test
    fun testBaseCase() {
        val result = RotateToMakeEqual().areTheyEqual(intArrayOf(1,2,3,4).toTypedArray(), intArrayOf(1,2,5,4).toTypedArray() )
        val result1 = RotateToMakeEqual().areTheyEqual(intArrayOf(1,2,3,4).toTypedArray(), intArrayOf(1,2,4,3).toTypedArray())
        println(result)
        println(result1)
    }
}