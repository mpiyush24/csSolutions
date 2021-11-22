package com.cssolutions.array

object RotateArray {
    fun rotateWithAuxSpace(a: Array<IntArray>) : Array<IntArray> {
        val m = a.size
        val n: Int = a[0].size
        val result = Array(n) { IntArray(m) }
        for (i in 0 until m) {
            val temp = IntArray(n)
            for (j in 0 until n) {
                temp[j] = a[i][j]
            }
            val col = m - i - 1
            for (j in 0 until m) {
                result[j][col] = temp[j]
            }
        }
        return result
    }

    fun inPlaceRotation(a: Array<IntArray>) {
        // For inplace rotation, we rotate topLeft, topRight, BottomRight, BottomLeft in the first pass.
        // In the second pass we move the pointer forward from each values we rotated in the first pass, i.e (0,1), (2,n), (m,n-1), (0,m-1)
        val m = a.size
        val n: Int = a[0].size
        val itr = if (m % 2 == 0) {
            m / 2 - 1
        } else {
            m / 2
        }
        for (x in 0..itr) {
            val up_bound_col = (n - 1) - x
            val up_bound_row = (m - 1) - x
            var postion_counter = 0 // This is used to figure out if for the current size we are iterating moving the 1 quadruplet 2nd or so on
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
                val temp2 = a[up_bound_row][up_bound_col - postion_counter]
                // assign the value preserved from right most column to this row
                a[up_bound_row][up_bound_col - postion_counter] = temp1
                //from lower left corner we are moving up
                temp1 = a[up_bound_row - postion_counter][x]
                // from lower left corner we moving upwards.
                a[up_bound_row - postion_counter][x] = temp2
                a[x][i] = temp1
                postion_counter++
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