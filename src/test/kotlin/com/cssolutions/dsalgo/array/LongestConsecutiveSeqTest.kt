package com.cssolutions.dsalgo.array

import org.junit.jupiter.api.Test

internal class LongestConsecutiveSeqTest {

    @Test
    fun test() {
        val testEntity = LongestConsecutiveSeq()
        val result = testEntity.longestConsecutive(intArrayOf(100,4,200,1,3,2))
        print(result)
    }

}