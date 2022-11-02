package com.cssolutions.dsalgo.medium

import org.junit.jupiter.api.Test

internal class LetterCasePermutationTest {

    @Test
    fun test() {
        val testEntity = LetterCasePermutation()

        val result = testEntity.letterCasePermutation("a1b2")

        result.forEach { println(it) }
    }

}