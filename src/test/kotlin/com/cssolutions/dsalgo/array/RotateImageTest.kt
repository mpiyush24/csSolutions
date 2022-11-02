package com.cssolutions.dsalgo.array

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RotateImageTest {

    @Test
    fun solve() {
        val testEntity = RotateImage()

        val result = testEntity.solve(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)))

        result.forEach { row ->
            row.forEach { print("$it,") }
            println()
        }
    }
}