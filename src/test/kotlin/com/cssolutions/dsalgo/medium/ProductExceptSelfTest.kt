package com.cssolutions.dsalgo.medium

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ProductExceptSelfTest {

    @Test
    fun productExceptSelf() {
        ProductExceptSelf().productExceptSelf(intArrayOf(1, 2, 3, 4)).map { print("$it ") }
        println()
        ProductExceptSelf().productExceptSelf(intArrayOf(-1,1,0,-3,3)).map { print("$it ") }
    }
}