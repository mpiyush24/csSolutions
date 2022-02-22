package com.cssolutions.dsalgo.medium

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RemoveKDigitsTest {

    @Test
    fun solve() {
        val result = RemoveKDigits().solve("1432219", 3)
        assertEquals("1219", result)
    }
    @Test
    fun solve1() {
        val result = RemoveKDigits().solve("10200", 1)
        assertEquals("200", result)
    }

    @Test
    fun solve2() {
        val result = RemoveKDigits().solve("1432219", 3)
        assertEquals("1219", result)
    }

    @Test
    fun solve3() {
        val result = RemoveKDigits().solve("1001", 2)
        assertEquals("0", result)
    }

    @Test
    fun solve4() {
        val result = RemoveKDigits().solve("1234567890", 9)
        assertEquals("0", result)
    }
}