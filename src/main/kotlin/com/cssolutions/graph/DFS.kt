package com.cssolutions.graph


class DFS {
    private val visitedArray = BooleanArray(1000) { false }
    fun dfs(adjList: Map<Int, List<Int>>) {
        for (pair in adjList) {
            if (!visitedArray[pair.key])
                helper(adjList, pair.key, pair.value)
        }
    }

    private fun helper(adjList: Map<Int, List<Int>>, node: Int, neighbors: List<Int>?) {
        visitedArray[node] = true
        println("Visiting Node: ${node}")
        neighbors?.forEach {
            if (!visitedArray[it]) {
                helper(adjList, it, adjList[node])
            }
        }
    }
}