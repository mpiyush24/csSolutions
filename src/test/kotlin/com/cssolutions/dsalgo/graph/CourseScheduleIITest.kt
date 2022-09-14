package com.cssolutions.dsalgo.graph

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CourseScheduleIITest {

    @Test
    fun findOrder() {
        val testEntity = CourseScheduleII()

        val result = testEntity.findOrder(3, arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(1,2)))
        result.forEach { println(it) }

    }
}