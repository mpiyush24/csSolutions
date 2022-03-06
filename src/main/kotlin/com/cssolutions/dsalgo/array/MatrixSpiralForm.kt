package com.cssolutions.dsalgo.array

import java.io.FileNotFoundException

class MatrixSpiralForm {
    @Throws(FileNotFoundException::class)

     fun dorun(a: Array<IntArray>, result: MutableList<Int>) {
        var doSpiral = true
        var i = 0
        var j = 0
        var topRow:Int
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
}