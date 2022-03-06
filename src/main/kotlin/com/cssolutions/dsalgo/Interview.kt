package com.cssolutions.dsalgo

//nums = [4,5,6,7,0,1,2], target = 0

fun main() {

    val input = arrayOf(0, 1, 2, 3, 4, 5, 6, 7)
    println(binarySearch(input, 0, input.size-1, 3))
}

fun binarySearch(array: Array<Int>, low: Int, high: Int, target: Int): Int {
    if (low > high) {
        return -1
    }
    val mid = (low + high) / 2

    if (array[mid] == target) {
        return mid
    }

    return if (target > array[mid]) {
        binarySearch(array, mid, high, target)
    } else {
        binarySearch(array, low, mid, target)
    }
}