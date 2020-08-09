package com.cssolutions.algorithm

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RegexMatcherKtTest {

    @Test
    fun matchRegularExpressionPatternWithNoSpecialChar() {
        val result = matchRegularExpression("theQuickBrownFoxJumpsOverTheLazyDog", "theQuickBrownFoxJumpsOverTheLazyDog")
        assertEquals(true, result)
    }

    @Test
    fun matchRegularExpressionPatternWithStar() {
        val result = matchRegularExpression("thB", "the*B")
        assertEquals(true, result)
    }

    @Test
    fun matchRegularExpressionPatternWithStar1() {
        val result = matchRegularExpression("thBFox", "the**BF*ox")
        assertEquals(true, result)
    }

    @Test
    fun matchRegularExpressionPatternWithStar2() {
        val result = matchRegularExpression("thBFox", "t.e**BF*ox")
        assertEquals(true, result)
    }

    @Test
    fun matchRegularExpressionPatternWithStar3() {
        val result = matchRegularExpression("thBFox", ".*x")
        assertEquals(true, result)
    }

    @Test
    fun matchRegularExpressionPatternWithStar4() {
        val result = matchRegularExpression("thBFox", ".*")
        assertEquals(true, result)
    }


    @Test
    fun matchRegularExpressionPatternWithStar5() {
        val result = matchRegularExpression("aaa", "a*a")
        assertEquals(true, result)
    }

    @Test
    fun matchRegularExpressionPatternWithStar6() {
        val result = matchRegularExpression("ab", ".*c")
        assertEquals(false, result)
    }

    @Test
    fun matchRegularExpressionPatternWithStar7() {
        val result = matchRegularExpression("aaa", "ab*a*c*a")
        assertEquals(true, result)
    }

    @Test
    fun matchRegularExpressionPatternWithStar8() {
        val result = matchRegularExpression("a", "ab*")
        assertEquals(true, result)
    }

  /*  @Test
    fun matchRegularExpressionPatternWithStar9() {
        val result = matchRegularExpression("aaa", "aaaa")
        assertEquals(false, result)
    }*/
/*
    @Test
    fun matchRegularExpressionPatternWithStar10() {
        val result = matchRegularExpression("a", "ab*a")
        assertEquals(false, result)
    }*/
}