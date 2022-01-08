package com.cssolutions.graph

import com.cssolutions.TestUtils
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TopologicalSortTest {

    @Test
    fun topologicalSort() {
        TopologicalSort().topologicalSort(TestUtils.createGraphFromAdjList(true))
    }
}