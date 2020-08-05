package com.cssolutions.backtrack

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NQueenProblemTest {

    @Test
    fun placeQueens() {
        val board = Array(8) { IntArray(8) { 0 } }
        NQueenProblem().placeQueens(board, 8, 8)
        for (rowIdx in board.indices) {
            for (colIdx in board[rowIdx].indices) {
                print("${board[rowIdx][colIdx]} ")
                if ((colIdx == 0 && rowIdx == 0) ||
                        (colIdx == 1 && rowIdx == 6) ||
                        (colIdx == 2 && rowIdx == 4) ||
                        (colIdx == 3 && rowIdx == 7) ||
                        (colIdx == 4 && rowIdx == 1) ||
                        (colIdx == 5 && rowIdx == 3) ||
                        (colIdx == 6 && rowIdx == 5) ||
                        (colIdx == 7 && rowIdx == 2)
                )
                    assertEquals(1, board[rowIdx][colIdx])
                else
                    assertEquals(0, board[rowIdx][colIdx])
            }
            println()
        }
    }
}