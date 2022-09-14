package com.cssolutions.dsalgo.graph

import org.junit.jupiter.api.Test

internal class FindStringOccurrenceTest {
    @Test
    fun strStr() {
        val testEntity = FindStringOccurrence()
        val result = testEntity.strStr("a", "a")
        println(result)
    }
}