package com.cssolutions.dsalgo.graph

class TopologicalSort {
    private val visited = BooleanArray(100) { false }
    private val result = mutableListOf<Int>()
    fun topologicalSort(adjancencyList: Map<Int, List<Int>>) {
        helper(adjancencyList, 1)
        result.forEach { println(it) }
    }

    private fun helper(adjancencyList: Map<Int, List<Int>>, node: Int) {
        visited[node] = true
        adjancencyList[node]?.forEach {
            if (!visited[it]) helper(adjancencyList, it)
        }
        result.add(node)
    }

}