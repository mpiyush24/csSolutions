package com.cssolutions.dsalgo.array

class PeakElement {

    fun solution(arr: IntArray): Int {
        return if (arr.size == 1 || arr[0] < arr[arr.size - 1]) {
            arr[0]
        } else findPeak(arr, 0, arr.size - 1)
    }
}

fun findPeak(arr: IntArray, left: Int, right: Int): Int {
    val mid = left + right / 2
    if (mid != arr.size && arr[mid + 1] < arr[mid])
        return arr[mid + 1];
    if (mid != 0 && arr[mid - 1] > arr[mid])
        return arr[mid];
    else if (arr[mid] < arr[right]) {
        return findPeak(arr, left, mid - 1)
    } else {
        return findPeak(arr, mid + 1, right)
    }
}