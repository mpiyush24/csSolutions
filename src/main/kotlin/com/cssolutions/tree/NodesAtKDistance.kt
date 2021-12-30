package com.cssolutions

import com.cssolutions.model.TreeNode

class DPWorld2 {
    fun distanceNode(root: TreeNode, targetNode: TreeNode, distance: Int): List<TreeNode> {
        val nodesOnPath = mutableListOf<DistanceNode>()
        pathToNode(root, targetNode, nodesOnPath, distance)

        val nodesWithTargetDistance = mutableListOf<TreeNode>()
        for (distanceNode in nodesOnPath) {
            val remainingDistance = distance - distanceNode.distance
            findNodesAtDistance(distanceNode.node, nodesWithTargetDistance, remainingDistance)
        }
        return nodesWithTargetDistance
    }

    private fun findNodesAtDistance(
        node: TreeNode?,
        nodesWithTargetDistance: MutableList<TreeNode>,
        remainingDistance: Int
    ) {
        if (node == null) return

        if (remainingDistance == 0) {
            nodesWithTargetDistance.add(node)
            return
        }
        findNodesAtDistance(node.left, nodesWithTargetDistance, remainingDistance - 1)
        findNodesAtDistance(node.right, nodesWithTargetDistance, remainingDistance - 1)
    }

    private fun pathToNode(
        root: TreeNode?,
        targetNode: TreeNode,
        nodesOnPath: MutableList<DistanceNode>,
        distance: Int
    ): Int {
        if (root == null) {
            return -1;
        }
        if (root.key == targetNode.key) {
            nodesOnPath.add(DistanceNode(root, 0))
            return 0
        }
        val distanceFromTargetNodeInLeftSubTree = pathToNode(root.left, targetNode, nodesOnPath, distance)
        if (distanceFromTargetNodeInLeftSubTree != -1) {
            nodesOnPath.add(DistanceNode(root, distanceFromTargetNodeInLeftSubTree + 1))
            return distanceFromTargetNodeInLeftSubTree + 1
        }
        val distanceFromTargetNodeInRightSubTree = pathToNode(root.right, targetNode, nodesOnPath, distance)

        if (distanceFromTargetNodeInRightSubTree != -1) {
            nodesOnPath.add(DistanceNode(root, distanceFromTargetNodeInRightSubTree + 1))
            return distanceFromTargetNodeInRightSubTree + 1
        }
        return -1;
    }
}

data class DistanceNode(val node: TreeNode, val distance: Int)