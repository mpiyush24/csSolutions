package com.cssolutions.tree

data class Node(
    var `val`: Int,
    var left: Node? = null,
    var right: Node? = null,
    var next: Node? = null,
)


class ConnectedTree {
    fun connect(root: Node?): Node? {

        if (root == null) return root
        connectNodes(root)
        return root
    }

    fun connectNodes(root: Node?) {

        if (root == null) return

        if (root.left == null && root.right == null) {
            return;
        }
        val left = root.left
        val right = root.right
        if (left != null) {
            if (right != null) {
                left.next = right
            } else {
                left.next = getNextRight(root)
            }
        }

        if (right != null) {
            right.next = getNextRight(root)
        }

        if (left != null) {
            connectNodes(left)
        }
        if (right != null) {
            connectNodes(right)
        }
    }

    fun getNextRight(root: Node): Node? {
        val next = root.next
        if (next == null) {
            return null;
        }

        return if (next.left != null) next.left
        else if (next.right != null) next.right
        else getNextRight(next)


    }
}