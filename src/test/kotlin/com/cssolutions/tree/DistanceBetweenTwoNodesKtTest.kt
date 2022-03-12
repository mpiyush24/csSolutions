package com.cssolutions.tree

import distanceBetweenNodes
import org.junit.jupiter.api.Test

internal class DistanceBetweenTwoNodesKtTest {

    @Test
    fun distanceBetweenNodesTest() {
        distanceBetweenNodes(6, 0, listOf(8, 3, 6, 4, 2, 1, 0))
    }
}