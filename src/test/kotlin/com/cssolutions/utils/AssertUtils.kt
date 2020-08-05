package com.cssolutions.utils

import org.junit.jupiter.api.Assertions

fun assertEqualList(ints: IntArray, values: IntArray) {
    for (i in ints.indices) {
        Assertions.assertEquals(ints[i], values[i])
    }
}