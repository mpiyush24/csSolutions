package com.cssolutions.tree

import com.cssolutions.main.BTreePrinter.printNode
import com.cssolutions.main.ReadInput.getTree
import com.cssolutions.model.Tree
import java.util.*

class TopView {
    var lindex = 0
    var rindex = 0
    fun run() {
        val t = getTree("TopView")
        val map: Map<Int, List<Tree>> = HashMap()
        printNode<Comparable<*>>(t)
        println("Without Hashing")
        topViewWithoutHashing(t)
        doTopView(t)
    }

    internal inner class QItem(var t: Tree?, var index: Int)

    private fun doTopView(tree: Tree?) {
        val q = ArrayDeque<QItem>()
        val map: MutableMap<Int, Tree?> = HashMap()
        q.add(QItem(tree, 0))
        while (!q.isEmpty()) {
            val qitem = q.poll()
            val t = qitem.t
            if (!map.containsKey(qitem.index)) {
                map[qitem.index] = qitem.t
            }
            if (t!!.left != null) {
                q.add(QItem(t.left, qitem.index - 1))
            }
            if (t.right != null) {
                q.add(QItem(t.right, qitem.index + 1))
            }
        }
        println("Hashing:")
        map.forEach { (k: Int?, v: Tree?) -> print(v!!.data.toString() + " ") }
    }

    private fun topViewWithoutHashing(t: Tree?) {
        val height = getHeight(t)
        for (i in 0 until height) {
            doprintTopView(t, 0, i)
        }
    }

    private fun doprintTopView(t: Tree?, index: Int, level: Int) {
        if (t == null) {
            return
        }
        if (level == 0) {
            if (index <= lindex) {
                lindex = index
                print(t.data.toString() + " ")
            } else if (index >= rindex) {
                rindex = index
                print(t.data.toString() + " ")
            }
        } else {
            doprintTopView(t.left, index - 1, level - 1)
            doprintTopView(t.right, index + 1, level - 1)
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