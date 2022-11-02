package com.cssolutions.dsalgo.array

/**
 * #maang
 */
class RotateImage {
    fun solve(matrix: Array<IntArray>): Array<IntArray> {

        for (i in matrix.indices)
            for (j in matrix[0].indices) {
                if (i <= j)
                    swap(i, j, matrix)
            }

        for (row in matrix) {
            row.reverse()
        }

        return matrix
    }

    fun swap(i: Int, j: Int, matrix: Array<IntArray>) {
        val temp = matrix[j][i]
        matrix[j][i] = matrix[i][j]
        matrix[i][j] = temp
    }
}