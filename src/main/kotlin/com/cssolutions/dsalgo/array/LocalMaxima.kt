package com.cssolutions.dsalgo.array

import com.cssolutions.main.IntResult

class LocalMaxima {

    fun doMaxima(arr: Array<Int>, beginIndex: Int, endIndex: Int, result:IntResult) {
        val e_index = (beginIndex + endIndex) / 2
        if (e_index > 0 && e_index < arr.size - 1) {
            if (arr[e_index] >= arr[e_index - 1] && arr[e_index] >= arr[e_index + 1]) {
                result.result = arr[e_index]
            } else if (arr[e_index] > arr[e_index - 1] && arr[e_index] < arr[e_index + 1]) {
                doMaxima(arr, e_index + 1, endIndex, result)
            } else {
                doMaxima(arr, beginIndex, e_index - 1, result)
            }
        }
        //Edge case
        if (e_index == 0) {
            doMaxima(arr, e_index + 1, endIndex, result)
        }
    }
}