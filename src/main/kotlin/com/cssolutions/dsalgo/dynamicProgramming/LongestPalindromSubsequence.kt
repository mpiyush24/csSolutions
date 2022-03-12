package com.cssolutions.dsalgo.dynamicProgramming

import com.cssolutions.dsalgo.main.ReadInput


class LongestPalindromSubsequence {
    fun run() {
        val sc = ReadInput.getScanner("longestPalindromeSubsequence")
        val str = sc.next()
        println("DP:" + doRun(str))
        println("recur:" + longestPalindrome(str, 0, str.length - 1))
    }

    private fun doRun(str: String): Int {
        val T = Array(str.length) { IntArray(str.length) }
        for (j in 0 until str.length) {
            for (i in j downTo 0) {
                if (i == j) {
                    T[i][j] = 1
                } else {
                    T[i][j] = 0
                }
            }
        }
        for (k in 1 until str.length) {
            var i = 0
            var j = k
            while (i < str.length - 1 && j < str.length) {
                if (str[i] == str[j]) {
                    T[i][j] = 2 + T[i + 1][j - 1]
                } else {
                    T[i][j] = Math.max(T[i][j - 1], T[i + 1][j])
                }
                i++
                j++
            }
        }
        return T[0][str.length - 1]
    }

    fun longestPalindrome(str: String, begin: Int, end: Int): Int {
        if (begin > end) {
            return 0
        }
        if (begin == end) {
            return 1
        }
        return if (str[begin] == str[end]) {
            2 + longestPalindrome(str, begin + 1, end - 1)
        } else {
            Math.max(longestPalindrome(str, begin + 1, end), longestPalindrome(str, begin, end - 1))
        }
    }
}