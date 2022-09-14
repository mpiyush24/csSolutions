package com.cssolutions.dsalgo.backtrack

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PermutationIITest {

    @Test
    fun solution() {
        val testEntity = PermutationII()
        val result = testEntity.permuteUnique(intArrayOf(1,1,2))

        result.forEach { value-> print("[${value.forEach { print(it) }},]}") }
    }
}