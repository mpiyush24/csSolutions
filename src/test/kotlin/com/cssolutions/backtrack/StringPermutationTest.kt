package com.cssolutions.backtrack

import com.cssolutions.dsalgo.backtrack.StringPermutation
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StringPermutationTest {

    @Test
    fun baseCase()
    {
        val result = mutableListOf<String>()
        val expected= listOf("ABC", "ACB", "BAC", "BCA", "CBA", "CAB")
        StringPermutation().doPermute("ABC", 0 , 2, result)
        assertTrue(expected.containsAll(result) && expected.size == result.size)
    }

}