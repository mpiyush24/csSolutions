package com.cssolutions.dynamicProgramming

import com.cssolutions.main.ReadInput

class LongestIncreasingSubset {
    fun run() {
        val sc = ReadInput.getScanner("longestIncreasingSubset")
        val size = sc.nextInt()
        val arr = ReadInput.getIntArray(size, sc.next())
        println(doRun(arr))
    }

    private fun doRun(arr: IntArray): Int {
        val T = IntArray(arr.size)
        for (i in T.indices) {
            T[i] = 1
        }
        for (i in 1 until arr.size) {
            for (j in 0 until i) {
                if (arr[j] < arr[i]) {
                    T[i] = Math.max(T[i], T[j] + 1)
                }
            }
        }
        var max = T[0]
        for (i in 1 until T.size) {
            max = Math.max(max, T[i])
        }
        return max
    }
}