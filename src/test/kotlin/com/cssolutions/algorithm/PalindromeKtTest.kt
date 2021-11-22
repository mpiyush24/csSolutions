package com.cssolutions.algorithm

import com.cssolutions.algorithm.Palindrome.isPalindrome
import com.cssolutions.algorithm.Palindrome.lengthOfTheLongestPalindrome
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


internal class PalindromeKtTest {

    @Test
    fun isPalindromeTest() {
        val isPalindrome = isPalindrome(121)
        assertTrue(isPalindrome)
    }

    @Test
    fun isPalindromeTestNegativeNumber() {
        val isPalindrome = isPalindrome(-121)
        assertFalse(isPalindrome)
    }
    @Test
    fun isPalindromeTestBigNumber() {
        val isPalindrome = isPalindrome(1000021)
        assertFalse(isPalindrome)
    }

    @Test
    fun lengthOfLongestPalindrome() {
        val length = lengthOfTheLongestPalindrome("abaccaxbbxa")
        println(length)
    }
}