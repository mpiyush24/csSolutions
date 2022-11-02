package com.cssolutions.dsalgo.backtrack

import org.junit.jupiter.api.Test

internal class PowersetTest {
    @Test
    fun test() {
        val testEntity = Powerset()
        val result = testEntity.subsets(intArrayOf(1,2,3))
        result.forEach { print(it) }
    }

    @Test
    fun test1() {
        val testEntity = Powerset()
        val result = testEntity.subsetsAlt(intArrayOf(2,1,3))
        result.forEach { print(it) }
    }

    @Test
    fun test2() {
        val testEntity = Powerset()
        val result = testEntity.subsetsWithDup(intArrayOf(2,1,3,2,3))
        result.forEach { print(it) }
    }




}