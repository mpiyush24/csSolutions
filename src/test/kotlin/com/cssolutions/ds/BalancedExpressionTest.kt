package com.cssolutions.ds

import com.cssolutions.dsalgo.ds.BalancedExpression
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BalancedExpressionTest {

    @Test
    fun baseCase() {
        assertTrue(BalancedExpression().execute("{{{{{{{{{{{{{[{}]}}}}}}}}}}}}}"))
    }
}