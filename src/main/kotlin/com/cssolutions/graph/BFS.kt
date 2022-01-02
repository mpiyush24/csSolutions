package com.cssolutions.graph

class BFS {

    private val explored = BooleanArray(20) { false }
    private val discovered = mutableListOf<Int>()

    fun bfs(adjList: Map<Int, List<Int>>) {

        discovered.add(1)
        helper(adjList, 1)
    }

    fun helper(adjList: Map<Int, List<Int>>, node: Int) {
        while (discovered.isNotEmpty()) {
            val gNode = discovered.removeAt(0)
            if (!explored[gNode]) {
                adjList[gNode]?.forEach {
                    discovered.add(it)
                }
                println(gNode)
                explored[gNode] = true
            }
        }
    }
}