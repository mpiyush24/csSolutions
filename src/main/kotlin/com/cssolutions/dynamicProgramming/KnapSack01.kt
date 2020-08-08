package com.cssolutions.dynamicProgramming

class KnapSack01 {

    fun knapsack01Recursion(weightArray: IntArray, profitArray: IntArray, requiredWeight: Int, profitSoFar: Int, itemNumber: Int): Int {
        if (requiredWeight == 0 || itemNumber == weightArray.size) {
            return 0
        }
        if (requiredWeight < weightArray[itemNumber]) {
            return knapsack01Recursion(weightArray, profitArray, requiredWeight, profitSoFar, itemNumber + 1)
        }
        val lmax = profitArray[itemNumber] + knapsack01Recursion(weightArray, profitArray, requiredWeight - weightArray[itemNumber], profitSoFar + profitArray[itemNumber], itemNumber + 1)
        val rmax = knapsack01Recursion(weightArray, profitArray, requiredWeight, profitSoFar, itemNumber + 1)
        return Math.max(lmax, rmax)
    }

    fun knapsack01DP(weightArray: IntArray, profitArray: IntArray, requiredWeight: Int): Int {
        val dpArray = Array(weightArray.size + 1) { IntArray(requiredWeight + 1) }
        for (i in weightArray.indices) {
            dpArray[i][0] = 0
            if (weightArray[i] < i) {
                dpArray[0][i] = profitArray[i]
            } else {
                dpArray[0][i] = 0
            }
        }
        for (i in 1 until dpArray.size) {
            for (j in 1 until dpArray[0].size) {
                if (j < weightArray[i - 1]) {
                    dpArray[i][j] = dpArray[i - 1][j] // 'i-1' because we are 1 index ahead
                    // of weight array.
                } else {
                    dpArray[i][j] = Math.max(profitArray[i - 1] + dpArray[i - 1][j - weightArray[i - 1]], dpArray[i - 1][j])
                }
            }
        }
        return dpArray[weightArray.size][requiredWeight]
    }
}