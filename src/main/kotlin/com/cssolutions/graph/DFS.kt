package com.cssolutions.graph


class DFS {
    private val explored = BooleanArray(1000) { false }
    fun dfs(adjList: Map<Int, List<Int>>) {
        for (pair in adjList) {
            if (!explored[pair.key])
                helper(adjList, pair.key)
        }
    }

    private fun helper(adjList: Map<Int, List<Int>>, node: Int) {
        explored[node] = true
        println("Visiting Node: ${node}")
        adjList[node]?.forEach {
            if (!explored[it]) {
                helper(adjList, it)
            }
        }
    }
}