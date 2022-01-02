package com.cssolutions.tree

import com.cssolutions.model.TreeNode

class FlattenTree {
    fun flatten(root: TreeNode?): TreeNode? {
        val headNode = TreeNode(0)
        flattenTree(root, headNode)
        return headNode.right
    }

    private fun flattenTree(root: TreeNode?, headNode: TreeNode?) {
        if (root == null || headNode == null) {
            return
        }
        val newNode = TreeNode(root.key)
        headNode.right = newNode
        flattenTree(root.left, newNode)
        flattenTree(root.right, newNode.right)
    }
}