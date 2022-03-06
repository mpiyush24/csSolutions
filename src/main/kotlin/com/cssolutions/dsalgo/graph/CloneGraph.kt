package com.cssolutions.dsalgo.graph

import com.cssolutions.dsalgo.model.GraphNode

class CloneGraph {
    fun cloneGraph(node: GraphNode?): GraphNode? {
        return if (node == null)
            null
        else createClone(node, node.clone(), Array(100) { null })
    }

    private fun createClone(node: GraphNode, clone: GraphNode, visitedArray: Array<GraphNode?>): GraphNode {
        visitedArray[node.`val` - 1] = clone
        for (neighbor in node.neighbors) {
            if (visitedArray[neighbor!!.`val` - 1] == null) {
                createClone(neighbor, neighbor.clone(), visitedArray)
            }
            clone.neighbors.add(visitedArray[neighbor.`val` - 1])
        }
        return clone
    }

    private fun GraphNode.clone() = GraphNode(this.`val`)
}