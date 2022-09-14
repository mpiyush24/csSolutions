package com.cssolutions.dsalgo.tree.sumdeepestlevel

import com.cssolutions.dsalgo.model.TreeNode
import kotlin.math.max

/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 */
class SumDeepestLevel {
    var level: Int = 0
    var gSum: Int = 0
    fun deepestLeavesSum(root: TreeNode?): Int {
        deepestLevel(root, 0)
        nodeAtKLevel(root, 0)

        return gSum
    }

    private fun nodeAtKLevel(root: TreeNode?, currentLevel: Int) {

        if (root == null) return

        if (currentLevel == level) {
            gSum += root.key
            return
        }
        nodeAtKLevel(root.left, currentLevel + 1)
        nodeAtKLevel(root.right, currentLevel + 1)
    }


    fun deepestLevel(root: TreeNode?, currentLevel: Int) {

        if (root == null) return

        if (root.left == null && root.right == null) return

        if (root.left != null) {
            deepestLevel(root.left, currentLevel + 1)
        }
        if (root.right != null) {
            deepestLevel(root.right, currentLevel + 1)
        }
        level = max(currentLevel + 1, level)
    }
}

