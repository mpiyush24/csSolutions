package com.cssolutions.array

import com.cssolutions.dsalgo.array.MatrixSpiralForm
import org.junit.jupiter.api.Test

internal class MatrixSpiralFormTest {

    @Test
    fun baseCase2X2() {
        val result: MutableList<Int> = mutableListOf()
        MatrixSpiralForm().dorun(arrayOf(intArrayOf(1, 2), intArrayOf(4, 3)), result)
        assertResults(result)

    }

    @Test
    fun baseCase3X2() {
        val result: MutableList<Int> = mutableListOf()
        MatrixSpiralForm().dorun(arrayOf(intArrayOf(1, 2), intArrayOf(6, 3), intArrayOf(5, 4)), result)
        assertResults(result)
    }

    @Test
    fun baseCase3X3() {
        val result: MutableList<Int> = mutableListOf()
        MatrixSpiralForm().dorun(arrayOf(intArrayOf(1, 2, 3), intArrayOf(8, 9, 4), intArrayOf(7, 6, 5)), result)
        assertResults(result)
    }

    @Test
    fun baseCase3X4() {
        val result: List<Int> = MatrixSpiralForm().spiralOrder(
            arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12))
        )
        result.forEach { print("$it,") }
    }

    private fun assertResults(result: MutableList<Int>) {
        for ((idx, value) in result.withIndex()) {
            assert(value == idx + 1)
        }
    }
}

