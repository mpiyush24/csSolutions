package com.cssolutions.dsalgo.tree

import com.cssolutions.dsalgo.main.BTreePrinter.printNode
import com.cssolutions.dsalgo.main.ReadInput.getTree
import com.cssolutions.dsalgo.model.Tree

class ValidBST {
    fun run() {
        val t = getTree("Tree")
        printNode<Comparable<*>>(t)
        val isValid = doRun(t)
        if (isValid) {
            println("yes")
        } else {
            println("no")
        }
    }

    private fun doRun(t: Tree?): Boolean {
        if (t == null) {
            return true
        }
        // leaf node
        if (t.left == null && t.right == null) {
            return true
        }
        val data = t.data as Int
        val left = t.left
        val right = t.right
        if (null != left && null != right) {
            if (data > left.data as Int && data < right.data as Int) {
                return doRun(t.left) && doRun(t.right)
            }
        } else if (left != null) {
            if (data > left.data as Int) {
                return doRun(left)
            }
        } else if (right != null) {
            if (data < right.data as Int) {
                return doRun(right)
            }
        }
        return false
    }
}