package com.cssolutions.dynamicProgramming

import com.cssolutions.main.ReadInput

class SubsetSum {
    fun run() {
        val sc = ReadInput.getScanner("subsetSum")
        val sum = sc.nextInt()
        val intArrSize = sc.nextInt()
        val arr = ReadInput.getIntArray(intArrSize, sc.next())
        println(doSubsetSum(arr, sum))
        println(isSubsetSum(arr, sum, arr.size - 1))
    }

    private fun doSubsetSum(arr: IntArray, sum: Int): Boolean {
        val T = Array(arr.size) { BooleanArray(sum + 1) }
        for (i in T.indices) {
            for (j in 0 until T[0].size) {
                if (j == 0) {
                    T[i][j] = true
                } else {
                    if (i > 0) {
                        if (j >= arr[i]) {
                            T[i][j] = T[i - 1][j] || T[i - 1][j - arr[i]]
                        } else {
                            T[i][j] = T[i - 1][j]
                        }
                    } else {
                        if (j - arr[i] == 0) {
                            T[i][j] = true
                        } else {
                            T[i][j] = false
                        }
                    }
                }
            }
        }
        return T[arr.size - 1][sum]
    }

    fun isSubsetSum(c: IntArray, sum: Int, index: Int): Boolean {
        return if (index == 0) {
            true
        } else isSubsetSum(c, sum - c[index], index - 1) || isSubsetSum(c, sum, index - 1)
    }
}