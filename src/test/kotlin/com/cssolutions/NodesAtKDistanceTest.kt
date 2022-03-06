package com.cssolutions

import com.cssolutions.dsalgo.model.TreeNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NodesAtKDistanceTest {

    @Test
    fun distanceNode() {
        val result = DPWorld2().distanceNode(TestUtils.createTree(),
            _root_ide_package_.com.cssolutions.dsalgo.model.TreeNode(11), 1)
        result.map { println(it.key) }
    }

}