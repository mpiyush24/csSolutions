package com.cssolutions.array

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CarPoolingTest {

    @Test
    fun carPooling() {
        println(
            CarPooling().carPooling(
                arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 5, 7)),
                3
            )
        )
    }

}