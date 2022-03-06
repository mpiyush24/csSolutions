package com.cssolutions.backtrack

import com.cssolutions.dsalgo.backtrack.CombinationSum
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class CombinationSumTest {

    @Test
    fun combinationSum2() {
        val result = CombinationSum().combinationSum2(intArrayOf(10,1,2,5,7,6), 30)
        println(result.joinToString())
        val p = PriorityQueue<Integer>(Collections.reverseOrder())
    }
}