package com.cssolutions.algorithm

import com.cssolutions.algorithm.isPalindrome
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


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
}