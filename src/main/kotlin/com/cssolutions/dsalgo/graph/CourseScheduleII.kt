package com.cssolutions.dsalgo.graph

/**
 * LC-210
 */
class CourseScheduleII {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        var courseMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()

        for (idx in 0 until numCourses) {

            courseMap[idx] = mutableListOf()
        }

        for (edge in prerequisites) {
            courseMap[edge[0]]!!.add(edge[1])
        }

        val order = mutableSetOf<Int>()

        for (entry in courseMap) {
            if (!dfs(entry.key, courseMap, mutableSetOf(),order)) return intArrayOf()
        }

        return order.toIntArray()

    }

    fun dfs(node: Int, graph: Map<Int, MutableList<Int>>, visited: MutableSet<Int>, order: MutableSet<Int>): Boolean {
        if (visited.contains(node)) return false
        visited.add(node)
        for (neighbor in graph[node]!!) {
            if (!dfs(neighbor, graph, visited, order)) return false
        }
        visited.remove(node)
        graph[node]!!.clear()
        order.add(node)
        return true
    }
}