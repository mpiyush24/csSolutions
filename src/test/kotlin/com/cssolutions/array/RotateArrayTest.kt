package com.cssolutions.array

import com.cssolutions.utils.assertEqualList
import org.junit.jupiter.api.Test

internal class RotateArrayTest {

    @Test
    fun baseCaseAuxSpace() {
        val result = RotateArray.rotateWithAuxSpace(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)))
        val expected = arrayOf(intArrayOf(7, 4, 1), intArrayOf(8, 5, 2), intArrayOf(9, 6, 3))
        for ( (rowIndex,values) in result.withIndex()) {
            assertEqualList(expected[rowIndex],values)
        }
    }

    @Test
    fun baseCase4X4InPlace() {
        val input = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12), intArrayOf(13, 14, 15, 16))
        RotateArray.inPlaceRotation(input)
        val expected = arrayOf(intArrayOf(13, 9, 5, 1), intArrayOf(14, 10, 6, 2), intArrayOf(15, 11, 7, 3), intArrayOf(16, 12, 8, 4))
        for ( (rowIndex,values) in input.withIndex()) {
            assertEqualList(expected[rowIndex],values)
        }
    }

    @Test
    fun baseCase5X5InPlace() {
        val input = arrayOf(intArrayOf(1, 2, 3, 4, 5), intArrayOf(6, 7, 8, 9, 10), intArrayOf(11, 12, 13, 14, 15),
                intArrayOf(16, 17, 18, 19, 20), intArrayOf(21, 22, 23, 24, 25))
        RotateArray.inPlaceRotation(input)
        val expected = arrayOf(intArrayOf(21, 16, 11, 6, 1), intArrayOf(22, 17, 12, 7, 2), intArrayOf(23, 18, 13, 8, 3), intArrayOf(24, 19, 14, 9, 4), intArrayOf(25, 20, 15, 10, 5))
        for ( (rowIndex,values) in input.withIndex()) {
            assertEqualList(expected[rowIndex],values)
        }
    }

}