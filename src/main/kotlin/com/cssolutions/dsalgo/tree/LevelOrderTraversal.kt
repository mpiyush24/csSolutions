package com.cssolutions.dsalgo.tree

import com.cssolutions.dsalgo.main.BTreePrinter.printNode
import com.cssolutions.dsalgo.main.ReadInput.getTree
import com.cssolutions.dsalgo.model.Tree

class LevelOrderTraversal {
    fun run() {
        val t = getTree("levelOrderTraversal")
        printNode<Comparable<*>>(t)
        doPrintLevelOrderTraversal(t)
    }

    private fun doPrintLevelOrderTraversal(t: Tree?) {
        val height = getHeight(t)
        var ltr = true
        for (i in 1..height) {
            printLevel(t, i, ltr)
            ltr = !ltr
            println()
        }
    }

    private fun printLevel(t: Tree?, i: Int, ltr: Boolean) {
        if (i == 1) {
            print(t!!.data.toString() + " ")
        } else {
            if (ltr) {
                if (t!!.left != null) {
                    printLevel(t.left, i - 1, ltr)
                }
                if (t.right != null) {
                    printLevel(t.right, i - 1, ltr)
                }
            } else {
                if (t!!.right != null) {
                    printLevel(t.right, i - 1, ltr)
                }
                if (t.left != null) {
                    printLevel(t.left, i - 1, ltr)
                }
            }
        }
    }

    private fun getHeight(t: Tree?): Int {
        if (t == null) {
            return 0
        }
        val lheight = getHeight(t.left)
        val rheight = getHeight(t.right)
        return Math.max(lheight, rheight) + 1
    }
}