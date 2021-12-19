package com.cssolutions.algorithm

import kotlin.math.max

object Palindrome {
    fun isPalindrome(integer: Int): Boolean {

        val numberAsString = integer.toString()

        var i = 0
        var j = numberAsString.length - 1
        var isPalindrome = true
        while (i <= j) {

            if (numberAsString[i] != numberAsString[j]) {
                isPalindrome = false
                break
            } else {
                i++;j--
            }
        }
        return isPalindrome
    }

    fun lengthOfTheLongestPalindrome(input: String): Int {

        val charArr = input.toCharArray()
        var maxLength = 1;

        for (i in 0..charArr.size) {
            // Even Length
            var lptr = i
            var rptr = i
            while (lptr >= 0 && rptr < charArr.size && charArr[lptr] == charArr[rptr]) {
                lptr--
                rptr++
            }
            var length = rptr - lptr - 1 // rptr - lptr + 1  - 2 (reducing to the last good known pallindrome length)
            maxLength = max(maxLength, length)
            // Odd Length
            lptr = i
            rptr = i + 1
            while (lptr >= 0 && rptr < charArr.size && charArr[lptr] == charArr[rptr]) {
                lptr--
                rptr++
            }
            length = rptr - lptr - 1
            maxLength = max(maxLength, length)
        }
        return maxLength
    }
}
