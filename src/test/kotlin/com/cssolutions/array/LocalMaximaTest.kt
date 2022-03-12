package com.cssolutions.array

import com.cssolutions.dsalgo.array.LocalMaxima
import com.cssolutions.dsalgo.main.IntResult
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LocalMaximaTest {
    @Test
    fun baseCase()
    {
        var intResult = IntResult()
        LocalMaxima().doMaxima(arrayOf(1, 2, 9, 7, 6, 5), 0, 5, intResult)
        assertEquals(9, intResult.result)
    }
}