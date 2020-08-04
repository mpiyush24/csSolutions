package com.cssolutions.array

import com.cssolutions.main.ReadInput
import java.io.FileNotFoundException

class MatrixSpiralForm {
    @Throws(FileNotFoundException::class)
    fun run() {
        val sc = ReadInput.getScanner("spiralMatrix")
        val m = sc.nextInt()
        val n = sc.nextInt()
        val a = Array(m) { IntArray(n) }
        while (sc.hasNextInt()) {
            for (i in 0 until m) {
                for (j in 0 until n) a[i][j] = sc.nextInt()
            }
        }
        dorun(a)
    }

    private fun dorun(a: Array<IntArray>) {
        var doSpiral = true
        var i = 0
        var j = 0
        var TR = -1
        var BR = a.size
        var LC = -1
        var RC: Int = a[0].size
        while (doSpiral) {
            while (j < RC) {
                println(a[i][j])
                j++
            }
            TR = i
            j--
            i++
            while (i < BR) {
                println(a[i][j])
                i++
            }
            RC = j
            j--
            i--
            while (j > LC) {
                println(a[i][j])
                j--
            }
            BR = i
            j++
            i--
            while (i > TR) {
                println(a[i][j])
                i--
            }
            LC = j
            j++
            i++
            //Check for odd and even no. of row and columns
            doSpiral = BR - TR > 1 && RC - LC > 1
        }
    }
}