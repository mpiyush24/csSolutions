package com.cssolutions.dsalgo.graph

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class WordSearchTest {

    @Test
    fun exist() {

        val result = WordSearch().exist(arrayOf(charArrayOf('A', 'B','C' , 'E'), charArrayOf('S','F','E','S'), charArrayOf('A','D','E', 'E')),"ABCEFSADEESE")

        print(result)
    }
}