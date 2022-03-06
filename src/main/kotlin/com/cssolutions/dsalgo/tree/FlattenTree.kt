package com.cssolutions.dsalgo.tree

import com.cssolutions.dsalgo.model.TreeNode

class FlattenTree {
    fun flatten(root: _root_ide_package_.com.cssolutions.dsalgo.model.TreeNode?): _root_ide_package_.com.cssolutions.dsalgo.model.TreeNode? {
        val headNode = _root_ide_package_.com.cssolutions.dsalgo.model.TreeNode(0)
        flattenTree(root, headNode)
        return headNode.right
    }

    private fun flattenTree(root: _root_ide_package_.com.cssolutions.dsalgo.model.TreeNode?, headNode: _root_ide_package_.com.cssolutions.dsalgo.model.TreeNode?) {
        if (root == null || headNode == null) {
            return
        }
        val newNode = _root_ide_package_.com.cssolutions.dsalgo.model.TreeNode(root.key)
        headNode.right = newNode
        flattenTree(root.left, newNode)
        flattenTree(root.right, newNode.right)
    }
}