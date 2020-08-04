package com.cssolutions.dynamicProgramming

import com.cssolutions.main.ReadInput

class KnapSack01 {
    fun run() {
        val sc = ReadInput.getScanner("knapsack")
        val size = sc.nextInt()
        val rw = sc.nextInt()
        val weight = sc.next().split(" ".toRegex()).toTypedArray()
        val `val` = sc.next().split(" ".toRegex()).toTypedArray()
        val w = IntArray(size)
        val v = IntArray(size)
        for (i in 0 until size) {
            w[i] = weight[i].toInt()
            v[i] = `val`[i].toInt()
        }
        println("Recursion: " + doRunRec(w, v, rw, 0, 0))
        println("DP: " + doRunDP(w, v, rw))
    }

    /**
     *
     * @param weight
     * array
     * @param val
     * array
     * @param w
     * required weight
     * @param v
     * required value
     * @param itemNumber
     * current Item
     */
    private fun doRunRec(weight: IntArray, `val`: IntArray, w: Int, v: Int, itemNumber: Int): Int {
        if (w == 0 || itemNumber == weight.size) {
            return 0
        }
        if (w < weight[itemNumber]) {
            return doRunRec(weight, `val`, w, v, itemNumber + 1)
        }
        val lmax = `val`[itemNumber] + doRunRec(weight, `val`, w - weight[itemNumber], v + `val`[itemNumber], itemNumber + 1)
        val rmax = doRunRec(weight, `val`, w, v, itemNumber + 1)
        return Math.max(lmax, rmax)
    }

    private fun doRunDP(weight: IntArray, `val`: IntArray, rw: Int): Int {
        val T = Array(weight.size) { IntArray(rw + 1) }
        for (i in weight.indices) {
            T[i][0] = 0
            if (weight[i] < i) {
                T[0][i] = `val`[i]
            } else {
                T[0][i] = 0
            }
        }
        for (i in 1 until weight.size) {
            for (j in 1 until T[0].size) {
                if (j < weight[i - 1]) {
                    T[i][j] = T[i - 1][j] // 'i-1' because we are 1 index ahead
                    // of weight array.
                } else {
                    T[i][j] = Math.max(`val`[i - 1] + T[i - 1][j - weight[i - 1]], T[i - 1][j])
                }
            }
        }
        return T[weight.size - 1][rw]
    }
}