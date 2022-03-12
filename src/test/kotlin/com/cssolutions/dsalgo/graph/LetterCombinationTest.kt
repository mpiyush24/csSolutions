package com.cssolutions.dsalgo.graph

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LetterCombinationTest {

    @Test
    fun letterCombinations() {
        val result = LetterCombination().letterCombinations("23")

        result.map { print("$it ") }
    }
}