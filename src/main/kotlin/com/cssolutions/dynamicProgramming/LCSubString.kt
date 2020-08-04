package com.cssolutions.dynamicProgramming

import com.cssolutions.main.ReadInput

class LCSubString {
    fun run() {
        val sc = ReadInput.getScanner("lcs")
        val seq1 = sc.next()
        val seq2 = sc.next()
        println("Recursion:" + doRun(seq1, seq2, seq1.length - 1, seq2.length - 1, false))
        println("DP:" + doRun(seq1, seq2))
    }

    private fun doRun(seq1: String, seq2: String, i: Int, j: Int, found: Boolean): Int {
        if (i < 0 || j < 0) {
            return 0
        }
        if (found == true) {
            return if (seq1[i] == seq2[j]) {
                1 + doRun(seq1, seq2, i - 1, j - 1, true)
            } else {
                0
            }
        }
        var r1 = 0
        if (seq1[i] == seq2[j]) {
            r1 = 1 + doRun(seq1, seq2, i - 1, j - 1, true)
        }
        return Math.max(r1, Math.max(doRun(seq1, seq2, i - 1, j, false), doRun(seq1, seq2, i, j - 1, false)))
    }

    private fun doRun(seq1: String, seq2: String): Int {
        val T = Array(seq1.length + 1) { IntArray(seq1.length + 1) }
        var max = 0
        for (i in 0..seq1.length) {
            for (j in 0..seq2.length) {
                if (i == 0 || j == 0) {
                    T[i][j] = 0
                } else {
                    if (seq1[i - 1] == seq2[j - 1]) {
                        T[i][j] = T[i - 1][j - 1] + 1
                        max = Math.max(max, T[i][j])
                    } else {
                        T[i][j] = 0
                    }
                }
            }
        }
        return max
    }
}