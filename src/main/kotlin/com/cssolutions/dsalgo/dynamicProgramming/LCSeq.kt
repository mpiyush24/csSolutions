package com.cssolutions.dsalgo.dynamicProgramming

import com.cssolutions.dsalgo.main.ReadInput

class LCSeq {
    fun run() {
        val sc = ReadInput.getScanner("lcs")
        val seq1 = sc.next()
        val seq2 = sc.next()
        println("Rec: " + doRunrec(seq1, seq2, seq1.length - 1, seq2.length - 1))
        println("DP: " + doRunDP(seq1, seq2))
    }

    private fun doRunrec(seq1: String, seq2: String, i: Int, j: Int): Int {
        if (i == -1 || j == -1) {
            return 0
        }
        return if (seq1[i] == seq2[j]) {
            1 + doRunrec(seq1, seq2, i - 1, j - 1)
        } else {
            Math.max(doRunrec(seq1, seq2, i - 1, j), doRunrec(seq1, seq2, i, j - 1))
        }
    }

    private fun doRunDP(seq1: String, seq2: String): Int {
        val T = Array(seq1.length + 1) { IntArray(seq2.length + 1) }
        for (i in 0..seq1.length) {
            for (j in 0..seq2.length) {
                if (i == 0 || j == 0) {
                    T[i][j] = 0
                } else {
                    if (seq1[i - 1] == seq2[j - 1]) {
                        T[i][j] = 1 + T[i - 1][j - 1]
                    } else {
                        T[i][j] = Math.max(T[i - 1][j], T[i][j - 1])
                    }
                }
            }
        }
        for (i in 1..seq1.length) {
            for (j in 1..seq2.length) {
                print(T[i][j].toString() + "<" + seq1[i - 1] + seq2[j - 1] + "> ")
            }
            println()
        }
        return T[seq1.length][seq2.length]
    }
}