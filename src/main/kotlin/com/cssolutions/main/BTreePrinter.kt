package com.cssolutions.main

import com.cssolutions.model.Tree
import java.util.*

object BTreePrinter {
    @JvmStatic
	fun <T : Comparable<*>?> printNode(root: Tree?) {
        val maxLevel = maxLevel<Comparable<*>>(root)
        printNodeInternal<Comparable<*>>(listOf(root), 1, maxLevel)
    }

    private fun <T : Comparable<*>?> printNodeInternal(nodes: List<Tree?>, level: Int, maxLevel: Int) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) return
        val floor = maxLevel - level
        val endgeLines = Math.pow(2.0, Math.max(floor - 1, 0).toDouble()).toInt()
        val firstSpaces = Math.pow(2.0, floor.toDouble()).toInt() - 1
        val betweenSpaces = Math.pow(2.0, (floor + 1).toDouble()).toInt() - 1
        printWhitespaces(firstSpaces)
        val newNodes: MutableList<Tree?> = ArrayList()
        for (node in nodes) {
            if (node != null) {
                print(node.data)
                newNodes.add(node.left)
                newNodes.add(node.right)
            } else {
                newNodes.add(null)
                newNodes.add(null)
                print(" ")
            }
            printWhitespaces(betweenSpaces)
        }
        println("")
        for (i in 1..endgeLines) {
            for (j in nodes.indices) {
                printWhitespaces(firstSpaces - i)
                if (nodes[j] == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1)
                    continue
                }
                if (nodes[j]!!.left != null) print("/") else printWhitespaces(1)
                printWhitespaces(i + i - 1)
                if (nodes[j]!!.right != null) print("\\") else printWhitespaces(1)
                printWhitespaces(endgeLines + endgeLines - i)
            }
            println("")
        }
        printNodeInternal<Comparable<*>>(newNodes, level + 1, maxLevel)
    }

    private fun printWhitespaces(count: Int) {
        for (i in 0 until count) print(" ")
    }

    private fun <T : Comparable<*>?> maxLevel(node: Tree?): Int {
        return if (node == null) 0 else Math.max(maxLevel<Comparable<*>>(node.left), maxLevel<Comparable<*>>(node.right)) + 1
    }

    private fun <T> isAllElementsNull(list: List<T>): Boolean {
        for (`object` in list) {
            if (`object` != null) return false
        }
        return true
    }
}