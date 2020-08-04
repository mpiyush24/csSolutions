package com.cssolutions.array

import com.cssolutions.main.IntResult
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LocalMaximaTest {

    @Test
    fun baseCase()
    {
        var intResult = IntResult()
        val result = LocalMaxima().doMaxima(arrayOf(1, 2, 9, 7, 6, 5), 0, 5, intResult)
        assertEquals(9, intResult.result)
    }
}