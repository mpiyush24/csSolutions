package com.cssolutions.array

import com.cssolutions.main.ReadInput
import java.io.FileNotFoundException

class RotateArray {
    @Throws(FileNotFoundException::class)
    fun run() {
        val sc = ReadInput.getScanner("matrixRotate")
        val m = sc.nextInt()
        val n = sc.nextInt()
        val a = Array(m) { IntArray(n) }
        while (sc.hasNextInt()) {
            for (i in 0 until m) {
                for (j in 0 until n) a[i][j] = sc.nextInt()
            }
        }
        //dorun(a);
        inPlaceRotation(a)
    }

    private fun dorun(a: Array<IntArray>) {
        val m = a.size
        val n: Int = a[0].size
        val b = Array(n) { IntArray(m) }
        for (i in 0 until m) {
            val temp = IntArray(n)
            for (j in 0 until n) {
                temp[j] = a[i][j]
            }
            for (j in m - i - 1 downTo 0) {
                for (k in 0 until n) {
                    b[k][j] = temp[k]
                }
            }
        }
        for (i in 0 until n) {
            for (j in 0 until m) {
                print(b[i][j].toString() + " ")
            }
            println()
        }
    }

    fun inPlaceRotation(a: Array<IntArray>) {
        val m = a.size
        val n: Int = a[0].size
        var iter = 0
        iter = if (m % 2 == 0) {
            m / 2 - 1
        } else {
            m / 2
        }
        for (x in 0..iter) {
            val up_bound_col = n - x - 1
            val up_bound_row = m - x - 1
            for (i in x until up_bound_row) { //from right top corner we are moving down
// preserve value from right most column
/*
				 *  1 2 3
				 *  4 5 6
				 *  7 8 9
				 *  temp1 = 3
				 *  (0,2) = 1
				 *  temp2 = 9
				 *  (2,2) = temp1
				 *  temp1 = 7
				 *  (3,0) = temp2
				 *  (0,0) = temp1
				 */
                var temp1 = a[i][up_bound_col]
                a[i][up_bound_col] = a[x][i]
                //preserve value from last row position
                val temp2 = a[up_bound_row][up_bound_col - i]
                // assign the value preserved from right most column to this row
                a[up_bound_row][up_bound_col - i] = temp1
                //from lower left corner we are moving up
                temp1 = a[up_bound_row - i][x]
                // from lower left corner we moving upwards.
                a[up_bound_row - i][x] = temp2
                a[x][i] = temp1
            }
        }
        for (i in 0 until n) {
            for (j in 0 until m) {
                print(a[i][j].toString() + " ")
            }
            println()
        }
    }
}