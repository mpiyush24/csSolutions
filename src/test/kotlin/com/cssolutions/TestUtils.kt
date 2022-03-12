package com.cssolutions

import com.cssolutions.dsalgo.graph.GraphUtils
import com.cssolutions.dsalgo.model.GraphNode
import com.cssolutions.dsalgo.model.TreeNode

object TestUtils {
    /**
     *                1
     *              /   \
     *             2     3
     *          /    \
     *         4      5
     *              /   \
     *            10        11
     *          /   \     /   \
     *        20     21 22    23
     */
    fun createTree() =
        TreeNode(
            key = 1,
            left = TreeNode(
                key = 2,
                left = TreeNode(4),
                right = TreeNode(
                    key = 5,
                    left = TreeNode(
                        10,
                        left = TreeNode(key = 20),
                        right = TreeNode(21)
                    ),
                    right = TreeNode
                        (
                        key = 11,
                        left = TreeNode(22),
                        right = TreeNode(23)
                    )
                )
            ),
            right = TreeNode(key = 3)
        )

    fun createGraph() = GraphNode(
        `val` = 1,
        neighbors = arrayListOf(
            GraphNode(
                2, arrayListOf(
                    GraphNode(3, arrayListOf(GraphNode(4))),
                    GraphNode(4, arrayListOf(GraphNode(5))),
                    GraphNode(5, arrayListOf(GraphNode(6))),
                    GraphNode(6, arrayListOf(GraphNode(7))),
                    GraphNode(8, arrayListOf(GraphNode(9))),
                    GraphNode(9, arrayListOf(GraphNode(10))
                    )
                )
            )
        )
    )

    fun createGraphFromAdjList(directed: Boolean): Map<Int, List<Int>> {

        val adjList = mutableListOf<IntArray>()

        adjList.add(intArrayOf(1,2))
        adjList.add(intArrayOf(1,3))
        adjList.add(intArrayOf(1,4))
        adjList.add(intArrayOf(2,4))
        adjList.add(intArrayOf(2,5))
        adjList.add(intArrayOf(3,6))
        adjList.add(intArrayOf(4,3))
        adjList.add(intArrayOf(4,6))
        adjList.add(intArrayOf(4,7))
        adjList.add(intArrayOf(4,1))
        adjList.add(intArrayOf(5,4))
        adjList.add(intArrayOf(5,7))
        adjList.add(intArrayOf(7,6))
        return GraphUtils.createGraphFromAdjancencyList(adjList, directed)
    }
}