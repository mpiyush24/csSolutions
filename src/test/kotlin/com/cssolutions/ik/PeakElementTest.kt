package com.cssolutions.ik

import com.cssolutions.array.PeakElement
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PeakElementTest {

    @Test
    fun solution() {
        println(PeakElement().solution(intArrayOf(5,6,7,8,9,1,2,3,4)))
        println(PeakElement().solution(intArrayOf(1)))
        println(PeakElement().solution(intArrayOf(2,1)))
        println(PeakElement().solution(intArrayOf(3,4,5,1,2)))
        println(PeakElement().solution(intArrayOf(4,5,6,7,0,1,2)))
        println(PeakElement().solution(intArrayOf(11,13,15,17)))
        println(PeakElement().solution(intArrayOf(11,13,15,17)))
        println(PeakElement().solution(intArrayOf(6,7,1,2,3,4,5)))
    }
}