package com.cssolutions.dsalgo.easy

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RotationalCipherTest {

    @Test
    fun rotationalCipher() {
        val result = RotationalCipher().rotationalCipher("Zebra-493", 3)
        println(result)
    }
}