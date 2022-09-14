package com.cssolutions.dsalgo.tree.sumdeepestlevel

import com.cssolutions.TestUtils.createTree
import org.junit.jupiter.api.Test

internal class SumDeepestLevelTest {
    @Test
    fun test() {
        val testEntity = SumDeepestLevel()
        val result = testEntity.deepestLeavesSum(createTree())

        print(result)
    }
}