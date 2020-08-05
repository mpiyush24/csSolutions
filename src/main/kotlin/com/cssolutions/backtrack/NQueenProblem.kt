package com.cssolutions.backtrack

import com.cssolutions.main.ReadInput

class NQueenProblem {

    fun placeQueens(board: Array<IntArray>, m: Int, n: Int): Boolean {
        if (n == 0) {
            return true
        }
        for (i in 0 until m) {
            for (j in 0 until m) {
                if (isSafeSquare(board, m, i, j)) { //if we found a safe square assign
                    board[i][j] = 1
                    if (placeQueens(board, m, n - 1)) {
                        return true
                    } else { // undo the assignment , eval next square
                        board[i][j] = 0
                    }
                }
            }
        }
        return false
    }

    private fun isSafeSquare(board: Array<IntArray>, m: Int, i: Int, j: Int): Boolean {
        for (p in 0 until m) {
            if (board[p][j] == 1 || board[i][p] == 1) {
                return false
            }
        }
        //Todo Optimize this loop. n^2 can be brought down to n.
        for (p in 0 until m) {
            for (q in 0 until m) {
                if (isDiagonalSquare(p, q, i, j)) {
                    if (board[p][q] == 1) {
                        return false
                    }
                }
            }
        }
        return true
    }

    private fun isDiagonalSquare(p: Int, q: Int, i: Int, j: Int): Boolean {
        return p + q == i + j || p - q == i - j
    }
}