package com.cssolutions.dsalgo.graph

class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val visitedArray = Array(board.size) { BooleanArray(board[0].size) { false } }
        val wordCharArray = word.toCharArray()
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == wordCharArray[0]) {
                    if (bfs(board, wordCharArray, visitedArray.copy(), 0, i, j)) {
                        return true
                    }
                }
            }
        }
        return false
    }

    fun bfs(
        board: Array<CharArray>,
        wordArray: CharArray,
        vA: Array<BooleanArray>,
        Widx: Int,
        i: Int,
        j: Int
    ): Boolean {

        if (Widx == wordArray.size) {
            return true
        }

        if (i < 0 || j < 0 || i >= board.size || j >= board[0].size || board[i][j] != wordArray[Widx] || vA[i][j]) {
            return false
        }

        vA[i][j] = true

        val result = bfs(board, wordArray, vA, Widx + 1, i, j + 1)
                || bfs(board, wordArray, vA, Widx + 1, i - 1, j)
                || bfs(board, wordArray, vA, Widx + 1, i + 1, j)
                || bfs(board, wordArray, vA, Widx + 1, i, j - 1)

        vA[i][j] = false

        return result
    }


    fun Array<BooleanArray>.copy() = map { it.clone() }.toTypedArray()
}