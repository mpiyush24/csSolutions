package com.cssolutions.array

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class KthLargestNumberTest {

    @Test
    fun findKthLargest() {
        val result = KthLargestNumber().findKthLargest(intArrayOf(3,2,1,5,6,4), 2)
        println(result)
    }
}