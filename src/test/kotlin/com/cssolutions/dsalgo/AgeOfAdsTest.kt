package com.cssolutions.dsalgo

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AgeOfAdsTest {

    @Test
    fun solve() {
        val counts = listOf(
            "900,google.com",
            "60,mail.yahoo.com",
            "10,mobile.sports.yahoo.com",
            "40,sports.yahoo.com",
            "300,yahoo.com",
            "10,stackoverflow.com",
            "20,overflow.com",
            "5,com.com",
            "2,en.wikipedia.org",
            "1,m.wikipedia.org",
            "1,mobile.sports",
            "1,google.co.uk"
        )
        AgeOfAds().solve(counts)
    }
}