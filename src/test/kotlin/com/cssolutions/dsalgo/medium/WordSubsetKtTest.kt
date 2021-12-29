package com.cssolutions.dsalgo.medium

import org.junit.jupiter.api.Test

internal class WordSubsetKtTest {

    @Test
    fun getWordSubSetTest() {
        val result = getWordSubSet(arrayOf("amazon", "apple", "facebook","google","leetcode"), arrayOf("o", "e"))
        result.forEach { print(it) }
    }

    @Test
    fun getWordSubSetTest2() {
        val result = getWordSubSet(arrayOf("bcedecccdb","daeeddecbc","ecceededdc","edadadccea","ebacdedcea","eddabdacec","cddbecbeca","eeababedcc","bcaddcdbad","aeeeeabeea"), arrayOf("cb","aae","ccc","ab","adc"))
        result.forEach { print(it) }
    }
}