package com.cssolutions.dsalgo.graph

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CourseScheduleTest {

    @Test
    fun canComplete() {
        val testEntity = CourseSchedule()
        print(testEntity.canComplete(2, arrayOf(intArrayOf(0,1),intArrayOf(1,0))))

    }
}