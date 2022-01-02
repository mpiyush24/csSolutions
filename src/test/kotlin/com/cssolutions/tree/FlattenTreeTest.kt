package com.cssolutions.tree

import com.cssolutions.TestUtils
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FlattenTreeTest {

    @Test
    fun flatten() {
     val result = FlattenTree().flatten(TestUtils.createTree())
        println(result)
    }
}