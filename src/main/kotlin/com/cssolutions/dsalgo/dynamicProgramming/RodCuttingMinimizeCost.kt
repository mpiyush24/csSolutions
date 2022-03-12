package com.cssolutions.dsalgo.dynamicProgramming

import com.cssolutions.dsalgo.main.ReadInput
import java.io.FileNotFoundException

class RodCuttingMinimizeCost {
    @Throws(FileNotFoundException::class)
    fun run() {
        val sc = ReadInput.getScanner("rodCutting")
        val sum = sc.nextInt()
        val size = sc.nextInt()
        val arr = sc.next()
        val arrw = sc.next()
        val w = ReadInput.getIntArray(size, arr)
        val v = ReadInput.getIntArray(size, arrw)
        println(dorun(sum, w, v))
    }

    private fun dorun(sum: Int, a: IntArray, v: IntArray): Int {
        val T = Array(a.size) { IntArray(sum + 1) }
        for (i in T.indices) {
            for (j in 0 until T[0].size) {
                if (i == 0) {
                    if (j == 0) {
                        T[i][j] = 0
                    } else if (j < a[0]) {
                        T[i][j] = 0
                    } else {
                        T[i][j] = j * v[i]
                    }
                } else {
                    if (j < a[i - 1]) {
                        T[i][j] = T[i - 1][j]
                    } else {
                        T[i][j] = Math.min(T[i - 1][j], v[i - 1] + T[i][j - a[i - 1]])
                    }
                }
            }
        }
        return T[T.size - 1][sum]
    }
}