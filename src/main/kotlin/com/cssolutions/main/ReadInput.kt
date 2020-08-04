package com.cssolutions.main

import com.cssolutions.model.Tree
import java.util.*

object ReadInput {
    fun getScanner(filename: String?): Scanner {
        val `is` = ReadInput::class.java.classLoader.getResourceAsStream(filename)
        val sc = Scanner(`is`)
        sc.useDelimiter("\n")
        return sc
    }

    @JvmStatic
	fun getTree(filename: String?): Tree? {
        val arr: MutableList<Int> = ArrayList()
        val sc = getScanner(filename)
        sc.useDelimiter(" ")
        sc.forEachRemaining { t: String -> arr.add(t.toInt()) }
        return doGetTreeInput(arr, 0, arr.size)
    }

    fun getIntArray(size: Int, arr: String): IntArray {
        val array = arr.split(" ".toRegex()).toTypedArray()
        val result = IntArray(size)
        for (i in 0 until size) {
            result[i] = array[i].toInt()
        }
        return result
    }

    private fun doGetTreeInput(arr: List<Int>, low: Int, high: Int): Tree? {
        if (high - low == 0) {
            return null
        }
        val r_index = (low + high) / 2
        val t = Tree(arr[r_index])
        val left = doGetTreeInput(arr, low, r_index)
        val right = doGetTreeInput(arr, r_index + 1, high)
        t.left = left
        t.right = right
        return t
    }
}