package com.cssolutions.graph

import com.cssolutions.TestUtils
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BFSTest {
    @Test
    fun testBFS() {
        BFS().bfs(TestUtils.createGraphFromAdjList(true))
        println("###")
        BFS().bfs(TestUtils.createGraphFromAdjList(false))
    }
}