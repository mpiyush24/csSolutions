package com.cssolutions.graph

import com.cssolutions.TestUtils
import com.cssolutions.dsalgo.graph.TopologicalSort
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TopologicalSortTest {

    @Test
    fun topologicalSort() {
        TopologicalSort().topologicalSort(TestUtils.createGraphFromAdjList(true))
    }
}