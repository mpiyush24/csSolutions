package com.cssolutions.dsalgo.easy

fun sumArray(arr: IntArray): IntArray{

    for( i in 1 until arr.size) {
        arr[i] = arr[i] + arr[i-1]
    }
    return arr
}