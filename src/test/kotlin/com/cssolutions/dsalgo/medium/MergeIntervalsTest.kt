package com.cssolutions.dsalgo.medium

import org.junit.jupiter.api.Test

internal class MergeIntervalsTest {

    @Test
    fun solve() {
        val array = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8,10), intArrayOf(15, 18))
        MergeIntervals().solve(array).map { println("${it[0]}..${it[1]}") }
    }

}