package com.cssolutions.dsalgo.medium

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class InsertIntervalsTest {

    @Test
    fun insert() {
        val testEntity = InsertIntervals()
        val result = testEntity.insert(arrayOf(intArrayOf(1, 3), intArrayOf(6,9)), intArrayOf(2,5))
        result.forEach { print("(${it[0]}, ${it[1]}),") }

        val result1 = testEntity.insert(arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6,7), intArrayOf(8,10), intArrayOf(12,16)), intArrayOf(4, 8))
        println()

        result1.forEach { print("(${it[0]}, ${it[1]}),") }
    }
}