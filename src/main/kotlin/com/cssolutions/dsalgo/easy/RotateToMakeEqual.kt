package com.cssolutions.dsalgo.easy

class RotateToMakeEqual {

    fun areTheyEqual(arr_a: Array<Int>, arr_b: Array<Int>): Boolean {
        // Write your code here
        arr_a.sort()
        arr_b.sort()
        return arr_a.contentEquals(arr_b)
    }
}