package com.cssolutions.dynamicProgramming

import kotlin.math.max
import kotlin.math.min

class ChampagneTower {
    fun champagneTowerRecursive(poured: Int, query_row: Int, query_glass: Int): Double {
        if (query_row == 0) {
            return (poured - 1).toDouble()
        }
        if (query_glass < 0 || query_glass > query_row) return 0.0 // Non existent glass in the tower
        val fromLeftOverFlow = max(0.0, champagneTowerRecursive(poured, query_row - 1, query_glass - 1)) / 2
        val fromRightOverFlow = max(0.0, champagneTowerRecursive(poured - 1, query_row - 1, query_glass)) / 2
        return min(1.0, fromLeftOverFlow + fromRightOverFlow) // overflow amount
    }

    fun champagneTowerDP(poured: Int, query_row: Int, query_glass: Int): Double {
        val table = Array(query_row + 1) { Array(query_row + 1) { 0.0 } }

        table[0][0] = poured.toDouble()

        for (i in 1..query_row) {
            for (j in 0..query_row) {
                val left: Double = if (j < 1 || j > i) 0.0 else table[i - 1][j - 1]
                val right: Double = if (j > i - 1) 0.0 else table[i - 1][j]
                val leftVal = if (left <= 1) 0.0 else (left - 1) / 2
                val rightVal = if (right <= 1) 0.0 else (right - 1) / 2
                table[i][j] = leftVal + rightVal
            }
        }
        return Math.min(1.0, table[query_row][query_glass])
    }
}