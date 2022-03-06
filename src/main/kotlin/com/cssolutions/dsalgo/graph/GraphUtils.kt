package com.cssolutions.dsalgo.graph

object GraphUtils {
    fun createGraphFromAdjancencyList(edges: List<IntArray>, directed: Boolean): Map<Int, MutableList<Int>> {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for (pair in edges) {
            graph.computeIfAbsent(pair[0]) { mutableListOf() } += pair[1]
            if (!directed) {
                graph.computeIfAbsent(pair[1]) { mutableListOf() } += pair[0]
            }
        }
        return graph
    }
}