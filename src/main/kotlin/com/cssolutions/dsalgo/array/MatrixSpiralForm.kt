package com.cssolutions.dsalgo.array

import java.io.FileNotFoundException

class MatrixSpiralForm {
    @Throws(FileNotFoundException::class)

    fun dorun(a: Array<IntArray>, result: MutableList<Int>) {
        var doSpiral = true
        var i = 0
        var j = 0
        var topRow: Int
        var bottomRow = a.size
        var leftColumn = -1
        var rightColumn: Int = a[0].size
        while (doSpiral) {
            while (j < rightColumn) {
                result.add(a[i][j])
                j++
            }
            topRow = i
            j--
            i++
            while (i < bottomRow) {
                result.add(a[i][j])
                i++
            }
            rightColumn = j
            j--
            i--
            while (j > leftColumn) {
                result.add(a[i][j])
                j--
            }
            bottomRow = i
            j++
            i--
            while (i > topRow) {
                result.add(a[i][j])
                i--
            }
            leftColumn = j
            j++
            i++
            //Check for odd and even no. of row and columns
            doSpiral = bottomRow - topRow > 1 && rightColumn - leftColumn > 1
        }
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {

        val result = mutableListOf<Int>()
        if (matrix.size == 0) {
            return result
        }

        var rowBegin = 0
        var colBegin = 0
        var rowEnd = matrix.size - 1
        var colEnd = matrix[0].size - 1


        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (j in colBegin..colEnd) {
                result.add(matrix[rowBegin][j])
            }
            rowBegin++
            for (i in rowBegin..rowEnd) {
                result.add(matrix[i][colEnd])
            }
            colEnd--
            if (rowBegin <= rowEnd) {
                for (j in colEnd downTo colBegin) {
                    result.add(matrix[rowEnd][j])
                }
            }
            rowEnd--
            if (colBegin <= colEnd) {
                for (i in rowEnd downTo rowBegin) {
                    result.add(matrix[i][colBegin])
                }
            }
            colBegin++
        }
        return result
    }
}