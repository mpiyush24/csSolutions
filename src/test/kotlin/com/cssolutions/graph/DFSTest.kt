package com.cssolutions.graph

import com.cssolutions.TestUtils
import org.junit.jupiter.api.Test

internal class DFSTest {
    @Test
    fun testDFS() {
        DFS().dfs(TestUtils.createGraphFromAdjList(true))
        println("###")
        DFS().dfs(TestUtils.createGraphFromAdjList(false))
    }
}